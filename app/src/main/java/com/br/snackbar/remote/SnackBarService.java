package com.br.snackbar.remote;

import com.br.snackbar.model.Ingreditent;
import com.br.snackbar.model.Order;
import com.br.snackbar.model.Promotion;
import com.br.snackbar.model.Snack;

import org.json.JSONStringer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SnackBarService {

    @GET("lanche")
    Call<List<Snack>> getSnacks();

    @GET("lanche/{id}")
    Call<Snack> getSnackById(@Path("id") String id);

    @GET("ingrediente")
    Call<List<Ingreditent>> getIngredients();

    @GET("ingrediente/de/{id}")
    Call<List<Ingreditent>> getIngredientsBySnackId(@Path("id") Integer id);

    @GET("promocao")
    Call<List<Promotion>> getPromotion();

    @GET("pedido")
    Call<Order> getOrder();

    @PUT("pedido/{id}")
    void sendOrder(@Path("id") String id);

    @PUT("pedido/{id}")
    void sendOrderWithaAditional(@Path("id") String id, @Body JSONStringer adittional);

}
