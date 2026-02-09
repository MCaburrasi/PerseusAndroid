package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import segundo.caburrasi.marcos.perseus.ui.components.ImagePost

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            Modifier.fillMaxWidth(0.95f)
        ) {
            items(
                count = 30,
                itemContent = {
                    ImagePost(
                        Modifier
                            .padding(8.dp)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    HomeScreen()
}