package com.charlezz.finalarchitecture.di.module

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.AppConstants
import com.charlezz.finalarchitecture.data.AppDataManager
import com.charlezz.finalarchitecture.data.DataManager
import com.charlezz.finalarchitecture.data.local.AppDBHelper
import com.charlezz.finalarchitecture.data.local.AppDatabase
import com.charlezz.finalarchitecture.data.local.DBHelper
import com.charlezz.finalarchitecture.data.pref.AppPreferencesHelper
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

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
    fun provideAppDatabase(context: Context, @Named("my_db") dbName: String): AppDatabase {
        return Room
                .inMemoryDatabaseBuilder(context,AppDatabase::class.java) // temporary
//                .databaseBuilder(context, AppDatabase::class.java, dbName) // permanent
                .fallbackToDestructiveMigration()
                .addCallback(object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        for( index in 0 until 10000){
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
    fun provideApiHelper():ApiHelper=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiHelper::class.java)


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

    @Provides
    @Named("my_pref")
    fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Named("my_db")
    fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }


}