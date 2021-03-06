package com.br.snackbar.presentation.promotion.snacks;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.br.snackbar.R;
import com.br.snackbar.presentation.adapter.SnackAdapter;
import com.br.snackbar.model.Ingreditent;
import com.br.snackbar.model.Snack;
import com.br.snackbar.remote.RetrofitConfig;
import com.br.snackbar.singleton.IngredientSingleton;
import com.br.snackbar.singleton.SnackSingleton;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SnackActivity extends Activity implements SnackView {

    @Inject SnackPresenter snackPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);
//        String fname=new File(getFilesDir(), "test.png").getAbsolutePath();

//        snackBarComponent = ((SnackBarApplication) getApplication()).getSnackComponent();
//        snackBarComponent.inject(this);
//        snackPresenter.findSnacks();
       //populateSnacks();
//        AndroidInjection.inject(this);
        populateSnacks();
        //TODO: Implementar Injeção de dependencia do dagger para os presenter
        populateIngredients();
    }

    private void populateRecycler(List<Snack> snacks){
        RecyclerView mRecyclerView = findViewById(R.id.rv_snack);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        SnackAdapter snackAdapter = new SnackAdapter(snacks);
        mRecyclerView.setAdapter(snackAdapter);

        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
    }

    private void populateIngredients() {
        Call<List<Ingreditent>> call = new RetrofitConfig().getSnack().getIngredients();
        call.enqueue(new Callback<List<Ingreditent>>() {
            @Override
            public void onResponse(Call<List<Ingreditent>> call, Response<List<Ingreditent>> response) {
                IngredientSingleton.getInstance().setIngredients(response.body());
            }

            @Override
            public void onFailure(Call<List<Ingreditent>> call, Throwable t) {

            }
        });
    }

    private void populateSnacks(){
        Call<List<Snack>> call = new RetrofitConfig().getSnack().getSnacks();
        call.enqueue(new Callback<List<Snack>>() {
            @Override
            public void onResponse(Call<List<Snack>> call, Response<List<Snack>> response) {
                SnackSingleton instance = SnackSingleton.getInstance();
                instance.setSnacks(response.body());
                populateRecycler(instance.getSnacks());
            }

            @Override
            public void onFailure(Call<List<Snack>> call, Throwable t) {

            }
        });
    }

    @Override
    public void populateSnackList(List<Snack> snacks) {
        RecyclerView mRecyclerView = findViewById(R.id.rv_snack);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        SnackAdapter snackAdapter = new SnackAdapter(snacks);
        mRecyclerView.setAdapter(snackAdapter);

        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
    }
}
