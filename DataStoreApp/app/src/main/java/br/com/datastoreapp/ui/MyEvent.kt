package br.com.datastoreapp.ui

sealed class MyEvent{
    data class SaveDarkThemeValue(val value: Boolean?): MyEvent()
    data class SelectedDarkThemeValue(val value: Boolean): MyEvent()
}
