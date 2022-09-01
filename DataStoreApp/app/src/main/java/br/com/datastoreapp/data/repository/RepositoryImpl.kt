package br.com.datastoreapp.data.repository

import br.com.datastoreapp.data.source.preferences.Preferences
import br.com.datastoreapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val preferences: Preferences
) : Repository {

    override suspend fun putDarkThemeValue(key: String, value: Boolean) {
        preferences.putDarkThemeValue(key, value)
    }

    override suspend fun getDarkThemeValue(key: String): Boolean? {
        return preferences.getDarkThemeValue(key)
    }
}