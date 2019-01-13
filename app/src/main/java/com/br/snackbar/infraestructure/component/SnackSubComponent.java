package com.br.snackbar.infraestructure.component;

import com.br.snackbar.infraestructure.module.SnackModule;
import com.br.snackbar.presentation.promotion.snacks.SnackActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {SnackModule.class})
public interface SnackSubComponent extends AndroidInjector<SnackActivity> {

    @Subcomponent.Builder
    abstract class Buider extends AndroidInjector.Builder<SnackActivity>{

    }
}
