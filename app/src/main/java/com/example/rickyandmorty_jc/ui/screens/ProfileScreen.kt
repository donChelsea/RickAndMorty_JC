package com.example.rickyandmorty_jc.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rickyandmorty_jc.R
import com.example.rickyandmorty_jc.ui.TraitCard
import com.example.rickyandmorty_jc.ui.screens.main.MainViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel = viewModel<MainViewModel>()
    val uiState = viewModel.uiState.collectAsState()
    val selectedProfile = uiState.value.selectedProfile

    ConstraintLayout(modifier = modifier.heightIn(min = 100.dp, max = 500.dp)) {
        val (name, location, image, traits) = createRefs()

        if (uiState.value.selectedProfile == null) {
            CircularProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = Color.Blue,
            )
        } else {
            Text(
                modifier = Modifier
                    .width(215.dp)
                    .constrainAs(name) {
                        top.linkTo(parent.top, margin = 40.dp)
                        start.linkTo(parent.start, margin = 14.dp)
                    },
                text = selectedProfile?.name.toString(),
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                modifier = Modifier
                    .width(200.dp)
                    .constrainAs(location) {
                        top.linkTo(name.bottom, margin = 6.dp)
                        start.linkTo(parent.start, margin = 14.dp)
                    },
                text = "${selectedProfile?.location?.name.toString()}, ${selectedProfile?.location?.dimension.toString()}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 2,
            )
            AsyncImage(
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top, margin = 30.dp)
                        end.linkTo(parent.end, margin = 8.dp)
                    }
                    .padding(12.dp)
                    .size(90.dp)
                    .clip(CircleShape),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(selectedProfile?.image)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .width(400.dp)
                    .constrainAs(traits) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top, margin = 200.dp)
                    },
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TraitCard(
                    icon = Icons.Default.Home,
                    iconBackground = Color.Blue,
                    text = stringResource(id = R.string.label_origin, selectedProfile?.origin?.name.toString()),
                )
                TraitCard(
                    icon = Icons.Default.Face,
                    iconBackground = Color.Yellow,
                    text = stringResource(id = R.string.label_species, selectedProfile?.species.toString()),
                )
                TraitCard(
                    icon = Icons.Default.Settings,
                    iconBackground = Color.Red,
                    text = stringResource(id = R.string.label_gender, selectedProfile?.gender.toString()),
                )
                TraitCard(
                    icon = Icons.Default.Star,
                    iconBackground = Color.Green,
                    text = stringResource(id = R.string.label_status, selectedProfile?.status.toString()),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen()
}