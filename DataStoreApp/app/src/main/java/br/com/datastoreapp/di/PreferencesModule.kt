package br.com.datastoreapp.di

import android.content.Context
import br.com.datastoreapp.data.source.preferences.Preferences
import br.com.datastoreapp.data.source.preferences.PreferencesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context): Preferences {
        return PreferencesImpl(context)
    }
}