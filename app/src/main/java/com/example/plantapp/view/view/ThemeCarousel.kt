package com.example.plantapp.view.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ThemeItem(theme: Theme, onThemeClick: (Theme) -> Unit) {
    Card(elevation = 5.dp,
            shape = RoundedCornerShape(5),
            modifier = Modifier
            .padding(8.dp)
    ) {

        Column(modifier = Modifier.clickable(onClick = { onThemeClick(theme) })) {

            Image(
                    painter = painterResource(theme.imageResource),
                    contentDescription = "Content description for visually impaired",
                    contentScale = ContentScale.None,
                    modifier = Modifier.width(150.dp).height(100.dp)
            )
            Text(text = theme.name,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(8.dp))
        }
    }
}