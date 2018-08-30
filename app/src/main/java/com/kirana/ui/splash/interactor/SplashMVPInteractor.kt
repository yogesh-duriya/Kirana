package com.kirana.ui.splash.interactor
import com.kirana.data.database.repository.questions.Question
import com.kirana.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface SplashMVPInteractor : MVPInteractor {

    fun seedQuestions(): Observable<Boolean>
    fun seedOptions(): Observable<Boolean>
    fun getQuestion() : Observable<List<Question>>
}