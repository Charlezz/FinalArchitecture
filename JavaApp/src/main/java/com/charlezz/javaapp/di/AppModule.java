package com.charlezz.javaapp.di;

import javax.inject.Singleton;

import com.charlezz.javaapp.feature.main.remote.PostService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class AppModule {

    @Provides
    @Singleton
    PostService providePostService(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PostService.class);
    }

}
