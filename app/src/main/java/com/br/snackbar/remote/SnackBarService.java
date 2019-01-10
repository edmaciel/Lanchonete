package com.br.snackbar.remote;

import com.br.snackbar.model.Snack;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SnackBarService {

    @GET("lanche/{id}")
    Call<Snack> getSnack(@Path("id") String id);

}
