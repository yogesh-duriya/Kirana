package com.kirana.data.database.repository.options

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface OptionsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(options: List<Options>)

    @Query("SELECT * FROM options WHERE question_id = :questionId")
    fun loadOptionsByQuestionId(questionId: Long): List<Options>

    @Query("SELECT * FROM options")
    fun loadAll(): List<Options>
}