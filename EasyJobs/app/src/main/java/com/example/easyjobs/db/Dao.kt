package com.example.easyjobs.db
import  androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(testEntity: TestEntity)

    @Query("SELECT * FROM testEnti")
    fun getAllTest(): Flow<List<TestEntity>>
}