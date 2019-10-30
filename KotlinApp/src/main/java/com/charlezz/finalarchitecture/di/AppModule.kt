package com.charlezz.finalarchitecture.di

import android.app.Application
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.AppConstants
import com.charlezz.finalarchitecture.feature.local.AppDatabase
import com.charlezz.finalarchitecture.feature.local.DBHelper
import com.charlezz.finalarchitecture.feature.local.DBHelperImpl
import com.charlezz.finalarchitecture.feature.local.PersonDao
import com.charlezz.finalarchitecture.feature.photo.PhotoHelper
import com.charlezz.finalarchitecture.feature.photo.PhotoHelperImpl
import com.charlezz.finalarchitecture.feature.pref.PreferencesHelper
import com.charlezz.finalarchitecture.feature.pref.PreferencesHelperImpl
import com.charlezz.finalarchitecture.feature.remote.ApiHelper
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room
                .inMemoryDatabaseBuilder(context, AppDatabase::class.java) // temporary
//                .databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME) // permanent
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
    fun provideApiHelper(): ApiHelper = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiHelper::class.java)

    @Provides
    @Singleton
    fun providePersonDao(appDatabase: AppDatabase): PersonDao {
        return appDatabase.dao()
    }

    @Provides
    @Singleton
    fun provideDataManager(personDao: PersonDao): DBHelper {
        return DBHelperImpl(personDao)
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(context:Context): PreferencesHelper {
        return PreferencesHelperImpl(context, AppConstants.PREF_NAME)
    }

    @Provides
    @Singleton
    fun providePhotoHelper(): PhotoHelper {
        return PhotoHelperImpl()
    }
}