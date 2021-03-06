package com.kirana.data.database.repository.questions

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "questions")
data class Question(
        @Expose
        @PrimaryKey
        var id: Long,

        @Expose
        @SerializedName("question_text")
        @ColumnInfo(name = "question_text")
        var questionText: String,

        @Expose
        @SerializedName("question_img_url")
        @ColumnInfo(name = "question_img_url")
        var imgUrl: String?,

        @Expose
        @SerializedName("updated_at")
        @ColumnInfo(name = "updated_at")
        var updatedAt: String?

)