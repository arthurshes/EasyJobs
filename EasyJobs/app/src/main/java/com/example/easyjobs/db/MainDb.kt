package com.example.easyjobs.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.easyjobs.db.typeConverters.AdModelExperienceConverter
import com.example.easyjobs.db.typeConverters.AdModelTownConverter
import com.example.easyjobs.network.model.admodel.AdWorkerModel

@Database(entities = [TestEntity::class, AdWorkerModel::class], version = 1)
@TypeConverters(AdModelTownConverter::class,AdModelExperienceConverter::class)
abstract class MainDb:RoomDatabase() {
    abstract fun getDao():Dao
}