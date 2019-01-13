package com.br.snackbar.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.br.snackbar.R;
import com.br.snackbar.model.Ingreditent;
import com.br.snackbar.model.Snack;
import com.br.snackbar.singleton.IngredientSingleton;
import com.br.snackbar.utils.DownloadImageTask;

import java.util.ArrayList;
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
        snackViewHolder.mSnackIngredients.setText(ingredients(snacks.get(position).getIngredients()));
    }

    @Override
    public int getItemCount() {
        return snacks != null ? snacks.size() : 0;
    }

    public class SnackViewHolder extends RecyclerView.ViewHolder{
        public TextView mSnack;
        public ImageView mImageSnack;
        public TextView mSnackIngredients;
        public TextView mSnackValue;
        public SnackViewHolder(@NonNull View itemView) {
            super(itemView);
            mSnack = itemView.findViewById(R.id.tv_snack_name);
            mSnackIngredients = itemView.findViewById(R.id.tv_ingredient);
            mImageSnack = itemView.findViewById(R.id.iv_snack);
            mSnackValue = itemView.findViewById(R.id.tvValueSnack);
        }
    }

    private String ingredients(List<Integer> ingredientList ){
        List<String> ingredients = new ArrayList<>();
        for (Ingreditent i : getIngredients(ingredientList)) {
            ingredients.add(i.getName());
        }
        return TextUtils.join(", ", ingredients);
    }

    private List<Ingreditent> getIngredients(List<Integer> ingredientList){
        List<Ingreditent> ingreditents = new ArrayList<>();
        for (Integer i : ingredientList) {
            ingreditents.add(IngredientSingleton.getInstance().getIngredients().get(i));
        }
        return ingreditents;
    }
}
