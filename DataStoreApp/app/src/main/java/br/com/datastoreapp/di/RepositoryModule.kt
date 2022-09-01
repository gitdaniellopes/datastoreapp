package br.com.datastoreapp.di

import br.com.datastoreapp.data.repository.RepositoryImpl
import br.com.datastoreapp.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(impl: RepositoryImpl): Repository
}