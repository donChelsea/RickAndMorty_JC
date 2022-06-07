package com.example.rickyandmorty_jc.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TraitCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconBackground: Color,
    text: String,
) {
    Box(
        modifier = modifier
            .size(width = 400.dp, height = 50.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = Color.Transparent),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Box(modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color = iconBackground),
                contentAlignment = Alignment.Center,
            ) {
                Icon(imageVector = icon, contentDescription = "")
            }
            Text(
                modifier = Modifier.width(200.dp),
                text = text,
                textAlign = TextAlign.Start,
                maxLines = 3,
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTraitCard() {
    TraitCard(icon = Icons.Default.AccountBox, text = "Account Box", iconBackground = Color.LightGray)
}