package com.example.rickyandmorty_jc.ui.screens.main

import com.example.rickyandmorty_jc.data.models.Character

sealed class BrowseAction {
    data class ViewCharacterProfile(val character: Character): BrowseAction() {}
}

data class CharactersState(
    val characters: List<Character> = emptyList()
)