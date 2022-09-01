package br.com.datastoreapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.datastoreapp.domain.usecase.GetDarkThemeValueUseCase
import br.com.datastoreapp.domain.usecase.PutDarkThemeValueUseCase
import br.com.datastoreapp.util.DARK_THEME_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDarkThemeValueUseCase: GetDarkThemeValueUseCase,
    private val putDarkThemeValueUseCase: PutDarkThemeValueUseCase
) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    init {
        getDarkTheme()
    }

    fun onEvent(event: MyEvent) {
        when (event) {
            is MyEvent.SaveDarkThemeValue -> saveDarkThemeValue(state.darkThemeValue)
            is MyEvent.SelectedDarkThemeValue -> state = state.copy(darkThemeValue = event.value)
        }
    }

    private fun saveDarkThemeValue(value: Boolean) {
        viewModelScope.launch {
            putDarkThemeValueUseCase(
                key = DARK_THEME_KEY,
                value = value
            )
        }
    }

    private fun getDarkTheme() = viewModelScope.launch {
        getDarkThemeValueUseCase(
            key = DARK_THEME_KEY
        )?.let {
            state = state.copy(darkThemeValue = it)
        }
    }
}