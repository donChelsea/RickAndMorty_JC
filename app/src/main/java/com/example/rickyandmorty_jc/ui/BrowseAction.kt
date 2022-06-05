package com.example.rickyandmorty_jc.ui

import com.example.rickyandmorty_jc.data.models.Character

sealed class BrowseAction {
    data class ViewCharacterProfile(val character: Character): BrowseAction() {}
}

data class CharactersState(
    val characters: List<Character> = emptyList(),
    val selectedProfile: Character.Profile? = null,
)
