package com.charlezz.javaapp.feature.local;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;

import com.charlezz.javaapp.R;
import com.charlezz.javaapp.databinding.FragmentPersonBinding;
import com.charlezz.javaapp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class PersonModule {
    @Provides
    @FragmentScope
    static FragmentPersonBinding provideBinding(PersonFragment fragment){
        return DataBindingUtil.inflate(LayoutInflater.from(fragment.getContext()), R.layout.fragment_person, null, false);
    }

    @Provides
    @FragmentScope
    static PersonViewModel provideViewModel(PersonFragment fragment, final DBHelper dbHelper){
        return ViewModelProviders.of(fragment, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                //noinspection unchecked
                return (T) new PersonViewModel(dbHelper);
            }
        }).get(PersonViewModel.class);
    }

    @Provides
    @FragmentScope
    static PersonAdapter provideAdapter(){
        return new PersonAdapter();
    }
}
