package com.example.easyjobs.db.typeConverters

import androidx.room.TypeConverter
import com.example.easyjobs.network.model.admodel.Town

class AdModelTownConverter {
    @TypeConverter
    fun converterTownDeclensionToString(town: Town):String{
        return town.declension
    }

    @TypeConverter
    fun converterTownGenitiveToString(town: Town):String{
        return town.genitive
    }

    @TypeConverter
    fun converterTownIdToString(town: Town):String{
        return town.id.toString()
    }

    @TypeConverter
    fun converterTownTitleToString(town: Town):String{
        return town.title
    }

    @TypeConverter
    fun converterStringToTown(title:String,id:String,genitive:String,declension:String):Town{
        return Town(declension,genitive,id.toInt(),title)
    }
}