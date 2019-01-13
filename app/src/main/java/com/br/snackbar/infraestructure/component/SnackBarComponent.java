package com.br.snackbar.infraestructure.component;

import com.br.snackbar.SnackBarApplication;
import com.br.snackbar.infraestructure.module.BuildersModule;
import com.br.snackbar.infraestructure.module.SnackBarModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {SnackBarModule.class, BuildersModule.class})
public interface SnackBarComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(SnackBarApplication application);
        SnackBarComponent build();
    }


}
