package br.com.datastoreapp.domain.usecase

import br.com.datastoreapp.domain.repository.Repository
import javax.inject.Inject

class GetDarkThemeValueUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(key: String) = repository.getDarkThemeValue(key)
}