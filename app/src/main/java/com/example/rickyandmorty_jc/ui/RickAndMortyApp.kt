package com.example.rickyandmorty_jc.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickyandmorty_jc.ui.screens.MainScreen
import com.example.rickyandmorty_jc.ui.theme.RickyAndMorty_JCTheme

@Composable
fun RickAndMortyApp() {
    MainScreen()
}

@Preview(showBackground = true)
@Composable
fun PreviewRickAndMortyApp() {
    RickyAndMorty_JCTheme {
        RickAndMortyApp()
    }
}