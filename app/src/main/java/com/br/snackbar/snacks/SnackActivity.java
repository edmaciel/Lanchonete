package com.br.snackbar.snacks;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.br.snackbar.R;
import com.br.snackbar.adapter.SnackAdapter;
import com.br.snackbar.model.Snack;
import com.br.snackbar.remote.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SnackActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);
//        String fname=new File(getFilesDir(), "test.png").getAbsolutePath();

       Call<List<Snack>> call = new RetrofitConfig().getSnack().getSnacks();
        call.enqueue(new Callback<List<Snack>>() {
            @Override
            public void onResponse(Call<List<Snack>> call, Response<List<Snack>> response) {
                populateRecycler(response.body());
            }

            @Override
            public void onFailure(Call<List<Snack>> call, Throwable t) {

            }
        });
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
}
