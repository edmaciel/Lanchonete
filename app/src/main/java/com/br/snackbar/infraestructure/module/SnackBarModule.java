package com.br.snackbar.infraestructure.module;

import android.content.Context;

import com.br.snackbar.SnackBarApplication;
import com.br.snackbar.remote.SnackBarService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class SnackBarModule {

    @Provides
    @Singleton
    public Context providerContext(SnackBarApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    public SnackBarService getSnackService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit.create(SnackBarService.class);
    }
}
