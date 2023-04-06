package com.example.easyjobs.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyjobs.R
import com.example.easyjobs.Splash.activities.MainContentActivity
import com.example.easyjobs.adapters.RcViewDialogAdapter
import java.util.*

class DialogSpinnerHelper {
    fun showSpinnerDialog(context: Context, list: ArrayList<String>, tvSelection: TextView) {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        val rootView = LayoutInflater.from(context).inflate(R.layout.spinner_category_layout, null)
        val adapter = RcViewDialogAdapter(dialog,tvSelection)
        val rcView = rootView.findViewById<RecyclerView>(R.id.rc_sp_view)
        val sv = rootView.findViewById<SearchView>(R.id.search_country)
        rcView.adapter=adapter
        dialog.setView(rootView)
        adapter.updateAdapter(list)
        setSearchView(adapter, list, sv)
        dialog.show()
    }

    private fun setSearchView(
        adapter: RcViewDialogAdapter,
        list: ArrayList<String>,
        sv: SearchView?
    ) {
        sv?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                val tempList = filterListData(list, newText)
                adapter.updateAdapter(tempList)
                return true
            }

        })
    }

    fun filterListData(list: ArrayList<String>, searchText: String?): ArrayList<String> {
        val filteredList = ArrayList<String>()
        for (selection: String in list) {
            if (searchText == null) {
                filteredList.add("No result")
                return filteredList
            }
            if (selection.lowercase(Locale.ROOT).startsWith(searchText.lowercase(Locale.ROOT)))
                filteredList.add(selection)
        }

        if (filteredList.size == 0) filteredList.add("Совподений не найдено")
        return filteredList
    }
}