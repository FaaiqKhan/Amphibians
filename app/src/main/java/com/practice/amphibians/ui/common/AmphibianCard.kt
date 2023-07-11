package com.practice.amphibians.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.practice.amphibians.R
import com.practice.amphibians.models.Amphibian
import com.practice.amphibians.ui.theme.AmphibiansTheme

@Composable
fun AmphibianCard(amphibian: Amphibian, modifier: Modifier = Modifier) {
    val title = amphibian.name + " (" + amphibian.type + ")"
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        shape = RoundedCornerShape(size = dimensionResource(id = R.dimen.card_corner))
    ) {
        Column {
            Text(
                text = title,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.card_inner_padding)),
                style = MaterialTheme.typography.titleLarge
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.image)
                    .build(),
                placeholder = painterResource(id = R.drawable.loading_img),
                error = painterResource(id = R.drawable.ic_broken_image),
                contentDescription = stringResource(id = R.string.amphibian_photo),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.card_image_height)),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = amphibian.description,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.card_inner_padding)),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AmphibianCardPreview() {
    AmphibiansTheme {
        AmphibianCard(
            amphibian = Amphibian(
                name = "Pacman",
                type = "Frog",
                description = "Largest frog",
                image = ""
            )
        )
    }
}