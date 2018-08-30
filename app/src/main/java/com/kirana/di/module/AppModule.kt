package com.kirana.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.kirana.BuildConfig
import com.kirana.data.database.AppDatabase
import com.kirana.data.database.repository.options.OptionsRepo
import com.kirana.data.database.repository.options.OptionsRepository
import com.kirana.data.database.repository.questions.QuestionRepo
import com.kirana.data.database.repository.questions.QuestionRepository
import com.kirana.data.network.ApiHeader
import com.kirana.data.network.ApiHelper
import com.kirana.data.network.AppApiHelper
import com.kirana.data.preferences.AppPreferenceHelper
import com.kirana.data.preferences.PreferenceHelper
import com.kirana.di.ApiKeyInfo
import com.kirana.di.PreferenceInfo
import com.kirana.util.AppConstants
import com.kirana.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule{

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper) : PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(apiKey = apiKey,
            userId = preferenceHelper.getCurrentUserId(),
            accessToken = preferenceHelper.getAccessToken())

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun provideQuestionRepoHelper(appDatabase: AppDatabase): QuestionRepo = QuestionRepository(appDatabase.questionsDao())

    @Provides
    @Singleton
    internal fun provideOptionsRepoHelper(appDatabase: AppDatabase): OptionsRepo = OptionsRepository(appDatabase.optionsDao())

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()


}