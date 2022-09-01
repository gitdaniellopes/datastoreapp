package br.com.datastoreapp.domain.usecase

import br.com.datastoreapp.domain.repository.Repository
import javax.inject.Inject

class PutDarkThemeValueUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(key: String, value: Boolean) =
        repository.putDarkThemeValue(key, value)
}