package com.br.snackbar.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.br.snackbar.R;
import com.br.snackbar.model.Snack;
import com.br.snackbar.utils.DownloadImageTask;

import java.util.List;

public class SnackAdapter extends RecyclerView.Adapter<SnackAdapter.SnackViewHolder> {

    private List<Snack> snacks;

    public SnackAdapter(List<Snack> snacks) {
        //TODO: Receber o context
        this.snacks = snacks;
    }

    @NonNull
    @Override
    public SnackViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SnackViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.snack_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SnackViewHolder snackViewHolder, int position) {
        new DownloadImageTask(snackViewHolder.mImageSnack).execute(snacks.get(position).getImage());
        snackViewHolder.mSnack.setText(snacks.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return snacks != null ? snacks.size() : 0;
    }

    public class SnackViewHolder extends RecyclerView.ViewHolder{
        public TextView mSnack;
        public ImageView mImageSnack;
        public TextView mSnackIngredients;
        public SnackViewHolder(@NonNull View itemView) {
            super(itemView);
            mSnack = itemView.findViewById(R.id.tv_snack_name);
            mSnackIngredients = itemView.findViewById(R.id.tv_ingredient);
            mImageSnack = itemView.findViewById(R.id.iv_snack);
        }
    }
}
