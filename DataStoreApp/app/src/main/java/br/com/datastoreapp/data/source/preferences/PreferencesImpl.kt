package br.com.datastoreapp.data.source.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private const val PREFERENCES_NAME = "preferences_name"

private val Context.datastore by preferencesDataStore(name = PREFERENCES_NAME)

class PreferencesImpl @Inject constructor(
    private val context: Context
) : Preferences {
    override suspend fun putDarkThemeValue(key: String, value: Boolean) {
        val preferencesKey = booleanPreferencesKey(key)
        context.datastore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun getDarkThemeValue(key: String): Boolean? {
        return try {
            val preferencesKey = booleanPreferencesKey(key)
            val preferences = context.datastore.data.first()
            preferences[preferencesKey]
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }
}