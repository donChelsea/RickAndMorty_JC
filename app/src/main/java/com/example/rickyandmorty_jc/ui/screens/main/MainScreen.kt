package com.example.rickyandmorty_jc.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickyandmorty_jc.R
import com.example.rickyandmorty_jc.ui.theme.RickyAndMorty_JCTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {

    val viewModel = viewModel<MainViewModel>()
    val uiState = viewModel.uiState

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.label_choose_a_character),
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 40.dp)
        )

        LazyColumn {

        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    RickyAndMorty_JCTheme {
        MainScreen()
    }
}