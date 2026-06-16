package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import segundo.caburrasi.marcos.perseus.ui.components.ImagePost
@Composable
fun MainPostScreen(
    modifier: Modifier = Modifier,
    viewModel: PerseusViewModel
) {
    var posts = viewModel.uiState.collectAsState().value.client?.write("Load|Post")
    viewModel.setPostsList(posts)

    if (viewModel.uiState.collectAsState().value.loggedIn){
        var liked = viewModel.uiState.collectAsState().value.client?.write("Load|Like")
        viewModel.setLikedList(liked)
    }

    Spacer(Modifier.size(12.dp))

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        LazyColumn(
            Modifier.fillMaxWidth(0.95f)
                .align(Alignment.TopCenter)
        ) {
            items(
                items = viewModel.uiState.value.posts
            ){ post ->
                ImagePost(Modifier, post, viewModel)
            }
        }
    }
}



/*@Preview(showBackground = true)
@Composable
fun MainPostPreview() {
    MainPostScreen()
}*/