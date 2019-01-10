package com.br.snackbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.br.snackbar.model.Snack;
import com.br.snackbar.remote.RetrofitConfig;
import com.br.snackbar.utils.DownloadImageTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView iv_response = findViewById(R.id.image);

        Call<Snack> call = new RetrofitConfig().getSnack().getSnack("1");
        call.enqueue(new Callback<Snack>() {
            @Override
            public void onResponse(Call<Snack> call, Response<Snack> response) {
                Snack snack = response.body();
                new DownloadImageTask(iv_response).execute(snack.getImage());
            }

            @Override
            public void onFailure(Call<Snack> call, Throwable t) {
                Log.e("SnackService   ", "Erro find snack:" + t.getMessage());
            }
        });
    }
}
