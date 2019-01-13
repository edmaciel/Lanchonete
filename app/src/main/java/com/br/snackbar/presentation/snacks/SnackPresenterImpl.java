package com.br.snackbar.presentation.promotion.snacks;

import com.br.snackbar.model.Snack;
import com.br.snackbar.remote.SnackBarService;
import com.br.snackbar.singleton.SnackSingleton;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SnackPresenterImpl implements SnackPresenter {

    private final SnackView snackView;
    @Inject
    SnackBarService snackBarService;

    public SnackPresenterImpl(SnackView snackView) {
        this.snackView = snackView;
    }

    @Override
    public void findSnacks() {
        Call<List<Snack>> call = snackBarService.getSnacks();
        call.enqueue(new Callback<List<Snack>>() {
            @Override
            public void onResponse(Call<List<Snack>> call, Response<List<Snack>> response) {
                SnackSingleton instance = SnackSingleton.getInstance();
                instance.setSnacks(response.body());
                snackView.populateSnackList(response.body());
            }

            @Override
            public void onFailure(Call<List<Snack>> call, Throwable t) {

            }
        });
    }

    @Override
    public void findIngredients() {

    }
}
