package ru.geekbrains.prodevelopment.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.geekbrains.prodevelopment.view.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}