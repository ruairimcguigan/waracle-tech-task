package com.waracle.techtask.di

import com.waracle.techtask.interactors.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorModule {

    @Binds
    abstract fun provideGetCakesInteractor(impl: GetCakesInteractorImpl): GetCakesInteractor
}
