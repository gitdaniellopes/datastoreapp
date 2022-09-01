package br.com.datastoreapp.domain.repository

interface Repository {

    suspend fun putDarkThemeValue(key: String, value: Boolean)

    suspend fun getDarkThemeValue(key: String): Boolean?
}