package com.br.snackbar.infraestructure.module;

import com.br.snackbar.presentation.promotion.snacks.SnackActivity;
import com.br.snackbar.presentation.promotion.snacks.SnackPresenter;
import com.br.snackbar.presentation.promotion.snacks.SnackPresenterImpl;
import com.br.snackbar.presentation.promotion.snacks.SnackView;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class SnackModule {

    @Binds
    abstract SnackView provideSnackView(SnackActivity snackActivity);

    @Provides
    public static SnackPresenter provideSnackPresenter(SnackView snackView){
        return new SnackPresenterImpl(snackView);
    }
}
