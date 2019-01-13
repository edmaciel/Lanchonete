package com.br.snackbar.singleton;

import com.br.snackbar.model.Ingreditent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class IngredientSingleton {
    private static final IngredientSingleton INSTANCE = new IngredientSingleton();

    public void setIngredients(List<Ingreditent> ingredients) {
        for (Ingreditent i : ingredients) {
            ingredientsMap.put(i.getId(), i);
        }
    }

    private Map<Integer, Ingreditent> ingredientsMap = new HashMap<>();

    public static IngredientSingleton getInstance() {
        return INSTANCE;
    }

    public  Map<Integer, Ingreditent> getIngredients(){
        return ingredientsMap;
    }

}
