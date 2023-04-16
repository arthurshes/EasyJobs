package com.example.easyjobs.db.typeConverters

import androidx.room.TypeConverter
import com.example.easyjobs.network.model.admodel.Experience

class AdModelExperienceConverter {
    ////Experience
    @TypeConverter
    fun converterExperienceTitleToString(experience: Experience):String{
        return experience.title
    }
    @TypeConverter
    fun converterExperienceIdToString(experience: Experience):String{
        return experience.id.toString()
    }


    @TypeConverter
    fun converterStringTitleToExperience(title:String,id:String):Experience{
        return Experience(id.toInt(),title)
    }


}