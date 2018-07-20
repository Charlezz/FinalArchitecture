package com.charlezz.finalarchitecture.di.module

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.AppConstants
import com.charlezz.finalarchitecture.data.AppDataManager
import com.charlezz.finalarchitecture.data.DataManager
import com.charlezz.finalarchitecture.data.local.AppDBHelper
import com.charlezz.finalarchitecture.data.local.AppDatabase
import com.charlezz.finalarchitecture.data.local.AppExecutors
import com.charlezz.finalarchitecture.data.local.dao.DBHelper
import com.charlezz.finalarchitecture.data.pref.AppPreferencesHelper
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import com.charlezz.finalarchitecture.di.annotation.DatabaseInfo
import com.charlezz.finalarchitecture.di.annotation.PreferenceInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule {

    val TAG = AppModule::class.java.simpleName

    @Provides
    @Singleton
    fun provideAppContext(app: App): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideApplication(app: App): Application {
        return app
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context, @DatabaseInfo dbName: String): AppDatabase {
        return Room
                .inMemoryDatabaseBuilder(context,AppDatabase::class.java) // temporary
//                .databaseBuilder(context, AppDatabase::class.java, dbName) // permanent
                .fallbackToDestructiveMigration()
                .addCallback(object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Log.e(TAG,"onCreate")
                        for( index in 0 until 100000){
//                            Log.v(TAG,"index $index")
                            val cv = ContentValues()
                            cv.put("name", "Name$index")
                            cv.put("birth", "$index")
                            db.insert("person", SQLiteDatabase.CONFLICT_REPLACE,cv)
                        }
                    }
                })
                .build()
    }

    @Provides
    @Singleton
    fun provideDBHelper(appDBHelper: AppDBHelper): DBHelper {
        return appDBHelper
    }

    @Provides
    @Singleton
    fun provideApiHelper():ApiHelper=Retrofit.Builder().baseUrl("http://www.google.com").build().create(ApiHelper::class.java)


    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

//    @Provides
//    @Singleton
//    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
//        return appApiHelper
//    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    fun provideAppExecutor(): AppExecutors {
        return AppExecutors()
    }

}