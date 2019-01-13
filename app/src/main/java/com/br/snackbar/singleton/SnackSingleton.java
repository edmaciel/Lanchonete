package com.br.snackbar.singleton;

import com.br.snackbar.model.Snack;

import java.util.List;

public final class SnackSingleton {
    private static final SnackSingleton INSTANCE = new SnackSingleton();

    public List<Snack> getSnacks() {
        return snacks;
    }

    public void setSnacks(List<Snack> snacks) {
        this.snacks = snacks;
    }

    private List<Snack> snacks;

    public static SnackSingleton getInstance() {
        return INSTANCE;
    }
}
