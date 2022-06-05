package com.example.rickyandmorty_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.rickyandmorty_jc.ui.screens.main.MainScreen
import com.example.rickyandmorty_jc.ui.theme.RickyAndMorty_JCTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickyAndMorty_JCTheme {
                MainScreen()
            }
        }
    }
}

