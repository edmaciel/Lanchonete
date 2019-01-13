package com.br.snackbar.infraestructure.module;



import android.app.Activity;

import com.br.snackbar.infraestructure.component.SnackSubComponent;
import com.br.snackbar.presentation.promotion.snacks.SnackActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        SnackSubComponent.class
})
public abstract class BuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(SnackActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindSnackActivityInjectorFactory(SnackSubComponent.Builder builder);
}
