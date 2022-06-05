package com.example.rickyandmorty_jc.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickyandmorty_jc.data.AppRepository
import com.example.rickyandmorty_jc.data.models.Character
import com.example.rickyandmorty_jc.ui.BrowseAction
import com.example.rickyandmorty_jc.ui.CharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AppRepository,
): ViewModel() {

    val uiState = MutableStateFlow(CharactersState())
    val send: (BrowseAction) -> Unit = { action ->
        when (action) {
            is BrowseAction.ViewCharacterProfile -> getCharacterProfile(action.character)
        }
    }

    init {
        repository.characters
            .map(::onCharactersUpdated)
            .onEach(uiState::emit)
            .launchIn(viewModelScope)
    }

    private fun getCharacterProfile(character: Character) {
        viewModelScope.launch {
            repository.getProfile(id = character.id.toString())
                .map(::onProfileUpdated)
                .onEach(uiState::emit)
                .launchIn(viewModelScope)
        }
    }

    private fun onCharactersUpdated(list: List<Character>): CharactersState =
        uiState.value.copy(characters = list)

    private fun onProfileUpdated(profile: Character.Profile?): CharactersState =
        uiState.value.copy(selectedProfile = profile)

}