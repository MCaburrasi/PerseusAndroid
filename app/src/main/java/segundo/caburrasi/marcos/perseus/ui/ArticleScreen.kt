package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import segundo.caburrasi.marcos.perseus.R
import segundo.caburrasi.marcos.perseus.ui.components.Carousel
import segundo.caburrasi.marcos.perseus.ui.components.ImagePost
import segundo.caburrasi.marcos.perseus.ui.components.NewsPost

@Composable
fun ArticleScreen(

){
    Column(

    ) {
        Text(
            stringResource(R.string.app_name),
            fontSize = 32.sp
        )

        Carousel(Modifier
            .fillMaxWidth(0.85f)
            .align(Alignment.CenterHorizontally)
        )

        Text(
            stringResource(R.string.app_name),
            fontSize = 32.sp
        )

        LazyColumn(

        ) {
            items(
                count = 30,
                itemContent = {
                    NewsPost(
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
fun ArticleScreenPreview(

){
    ArticleScreen()
}