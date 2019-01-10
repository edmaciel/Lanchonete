package com.br.snackbar.remote;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig(){
       this.retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public SnackBarService getSnack() {
        return this.retrofit.create(SnackBarService.class);
    }
}
