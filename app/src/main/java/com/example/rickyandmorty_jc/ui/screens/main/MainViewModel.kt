package com.example.rickyandmorty_jc.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickyandmorty_jc.data.AppRepository
import com.example.rickyandmorty_jc.data.models.Character
import com.example.rickyandmorty_jc.ui.screens.main.BrowseAction
import com.example.rickyandmorty_jc.ui.screens.main.CharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AppRepository,
): ViewModel() {

    val uiState = MutableStateFlow(CharactersState())
    val send: (BrowseAction) -> Unit = { action ->
        when (action) {
            is BrowseAction.ViewCharacterProfile -> {}
        }
    }

    init {
        viewModelScope.launch {
            repository.characters.collect {
                onCharactersUpdated(it)
            }
        }
    }

    private fun onCharactersUpdated(list: List<Character>)
            : CharactersState = uiState.value.copy(characters = list)

}