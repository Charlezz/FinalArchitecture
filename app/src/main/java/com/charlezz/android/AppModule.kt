package com.charlezz.android

import android.content.Context
import android.content.SharedPreferences
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.charlezz.android.core.recyclerview.DividerItemDecoration
import com.charlezz.android.db.AppDatabase
import com.charlezz.android.db.entity.Post
import com.charlezz.android.db.entity.PostDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @BaseUrl
    @Provides
    @Singleton
    fun provideBaseUrl() = "https://charlezz.com"

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .registerTypeAdapter(Post::class.java, PostDeserializer())
                .create()
    }


    @Provides
    @Singleton
    fun provideRetrofit(@BaseUrl baseUrl: String, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "charlezz.db")
                .fallbackToDestructiveMigration()
                .build()
//        return Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
//                .fallbackToDestructiveMigration()
//                .build()
    }

    @Provides
    @Singleton
    fun provideEncryptedSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        val fileName = "default.pref"
        val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                MasterKey.DEFAULT_MASTER_KEY_ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .setKeySize(MasterKey.DEFAULT_AES_GCM_MASTER_KEY_SIZE)
                .build()

        val masterKey = MasterKey.Builder(context)
                .setKeyGenParameterSpec(keyGenParameterSpec)
                .build()

        return EncryptedSharedPreferences.create(
                context,
                fileName,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    @Provides
    fun provideLinearLayoutManager(@ApplicationContext context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @Provides
    fun provideDividerItemDecoration(@ApplicationContext context: Context): DividerItemDecoration {
        return DividerItemDecoration(context, DividerItemDecoration.DIVIDER_HORIZONTAL).apply {
            setDividerMargin(16f)
            setLastItemDividerVisible(true)
        }
    }

}