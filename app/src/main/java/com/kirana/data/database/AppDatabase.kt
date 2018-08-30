package com.kirana.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.kirana.data.database.repository.options.Options
import com.kirana.data.database.repository.options.OptionsDao
import com.kirana.data.database.repository.questions.Question
import com.kirana.data.database.repository.questions.QuestionsDao

@Database(entities = [(Question::class), (Options::class)], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun optionsDao(): OptionsDao

    abstract fun questionsDao() : QuestionsDao
}