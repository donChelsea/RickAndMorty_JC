package com.example.rickyandmorty_jc.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.rickyandmorty_jc.data.models.Character
import com.example.rickyandmorty_jc.data.models.toDomain
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    private val apiService: ApolloApiService
) {

    private val charactersCache = MutableStateFlow<List<Character>>(emptyList())

    val characters: Flow<List<Character>> = charactersCache.onStart { refresh() }

    private suspend fun refresh() {
        val result = apiService.getCharacters() ?: return

        charactersCache.value = with(result) {
            characters?.results?.map { it?.toDomain() } as List<Character>
        }
    }

}