package com.kirana.ui.splash.interactor

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.internal.`$Gson$Types`
import com.kirana.data.database.repository.options.Options
import com.kirana.data.database.repository.options.OptionsRepo
import com.kirana.data.database.repository.questions.Question
import com.kirana.data.database.repository.questions.QuestionRepo
import com.kirana.data.network.ApiHelper
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.ui.base.interactor.BaseInteractor
import com.kirana.util.AppConstants
import com.kirana.util.FileUtils
import io.reactivex.Observable
import javax.inject.Inject

class SplashInteractor @Inject constructor(private val mContex: Context, private val questionRepoHelper: QuestionRepo, private val optionsRepoHelper: OptionsRepo, preferenceHelper: PreferenceHelper, apiHelper: ApiHelper ) : BaseInteractor(preferenceHelper, apiHelper), SplashMVPInteractor{

    override fun seedQuestions(): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()
        return questionRepoHelper.isQuestionsRepoEmpty().concatMap { isEmpty ->
            if (isEmpty){
                val type = `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Question::class.java)
                val questionList = gson.fromJson<List<Question>>(
                        FileUtils.loadJSONFromAsset(mContex, AppConstants.SEED_DATABASE_QUESTIONS),
                        type)
                questionRepoHelper.insertQuestions(questionList)
            }else
                Observable.just(false)
        }
    }

    override fun seedOptions(): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()
        return optionsRepoHelper.isOptionsRepoEmpty().concatMap { isEmpty ->
            if (isEmpty){
                val type = `$Gson$Types`.newParameterizedTypeWithOwner( null, List::class.java, Options::class.java)
                val optionsList = gson.fromJson<List<Options>>(
                        FileUtils.loadJSONFromAsset(
                                mContex,
                                AppConstants.SEED_DATABASE_OPTIONS),
                        type)
                 optionsRepoHelper.insertOptions(optionsList)
            }else
                Observable.just(false)
        }
    }

    override fun getQuestion(): Observable<List<Question>> {
        return questionRepoHelper.loadQuestions()
    }
}