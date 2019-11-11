package com.charlezz.javaapp.di;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.charlezz.javaapp.App;
import com.charlezz.javaapp.feature.local.AppDatabase;
import com.charlezz.javaapp.feature.local.User;
import com.charlezz.javaapp.feature.local.UserDao;
import com.charlezz.javaapp.feature.remote.PostService;

import java.util.Locale;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    Application bindApp(App app){
        return app;
    }

    @Provides
    @Singleton
    PostService providePostService(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PostService.class);
    }

    @Provides
    @Singleton
    Context provideContext(App app){
        return app;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context){
        return Room
                .inMemoryDatabaseBuilder(context,AppDatabase.class) // temporary
//                .databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME) // permanent
                .fallbackToDestructiveMigration()
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        for( int i =0; i< 10000;i++){
                            ContentValues cv = new ContentValues();
                            cv.put("name", String.format(Locale.getDefault(),"Name %d", i));
                            cv.put("birth" ,String.format(Locale.getDefault(),"Birth %d", i));
                            db.insert(User.class.getSimpleName(), SQLiteDatabase.CONFLICT_REPLACE,cv);
                        }
                    }
                })
                .build();
    }

    @Provides
    @Singleton
    UserDao providePersonDao(AppDatabase appDatabase){
        return appDatabase.dao();
    }

}
