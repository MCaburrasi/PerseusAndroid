package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import segundo.caburrasi.marcos.perseus.ui.components.ImagePost
@Composable
fun MainPostScreen(
    modifier: Modifier = Modifier,
    viewModel: PerseusViewModel
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            Modifier.fillMaxWidth(0.95f)
        ) {
            items(
                items = viewModel.uiState.value.posts
            ){ post ->
                ImagePost(Modifier, post)
            }
        }
    }
}



/*@Preview(showBackground = true)
@Composable
fun MainPostPreview() {
    MainPostScreen()
}*/