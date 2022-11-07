package com.waracle.techtask.interactors

import com.waracle.techtask.repo.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object InteractorModule {

    @Provides
    fun provideGetCakesInteractor(repo: Repository): GetCakesInteractor = GetCakesInteractorImpl(repo)
}
