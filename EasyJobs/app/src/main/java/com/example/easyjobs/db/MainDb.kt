package com.example.easyjobs.db

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [TestEntity::class,ChatItemEntity::class], version = 1)
abstract class MainDb:RoomDatabase() {
    abstract fun getDao():Dao
}