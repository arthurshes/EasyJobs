package com.example.easyjobs.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ChatTable")
data class ChatItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "nameUser")
    val name: String?,
    @ColumnInfo(name = "imageUser")
    val image: String,
    @ColumnInfo(name = "timeUser")
    val time: Int = 0
)
