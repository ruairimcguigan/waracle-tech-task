package com.waracle.techtask.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import com.waracle.techtask.R
import com.waracle.techtask.ui.CakeUi

@Composable
fun CakesList(cakes: List<CakeUi>) {
    val cakeData = remember { cakes }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = grid_4, vertical = grid_4)
    ) {
        items(cakeData) { CakeListItem(it) }
    }
}

@Composable
fun CakeListItem(cakeUi: CakeUi) {
    Card(
        modifier = Modifier
            .padding(horizontal = grid_2, vertical = grid_2)
            .fillMaxWidth(),
        elevation = grid_1,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(grid_4))
    ) {
        Row {
            CakeImage(cakeUi.image)
            Column(
                modifier = Modifier
                    .padding(horizontal = grid_2)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = cakeUi.title, style = MaterialTheme.typography.h6)
                Text(text = cakeUi.desc, style = MaterialTheme.typography.caption)
            }
        }
    }
}

@Composable
fun CakeImage(cakeUrl: String) = Image(
    painter = rememberAsyncImagePainter(cakeUrl),
    contentDescription = "a cake",
    modifier = Modifier
        .padding(grid_2)
        .size(grid_21)
        .clip(RoundedCornerShape(corner = CornerSize(grid_2)))
)

@Composable
fun LoadingProgressView() = Row(
    modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
) {
    CircularProgressIndicator(
        modifier = Modifier.size(grid_8),
        color = Purple700,
        strokeWidth = grid_1
    )
}

@Composable
fun ErrorView(
    @StringRes title: Int,
    @StringRes retryButtonText: Int,
    errorMessage: String,
    retryOnError: () -> Unit
) {
    AlertDialog(
        title = { Text(text = stringResource(title)) },
        text = { Text(text = errorMessage) },
        onDismissRequest = { },
        confirmButton = {
            TextButton(onClick = { retryOnError() })
            { Text(text = stringResource(id = retryButtonText)) }
        },
    )
}

@Composable
fun ToolbarWithRefreshAction(
    @DrawableRes refreshIcon: Int,
    retryFetchCakes: () -> Unit
) = TopAppBar(
    title = { Text(stringResource(id = R.string.app_name), color = Color.White) },
    backgroundColor = Purple500,
    actions = {
        IconButton(onClick = { retryFetchCakes() }) {
            Icon(painterResource(id = refreshIcon), "click me to refresh", tint = Color.White)
        }
    })

