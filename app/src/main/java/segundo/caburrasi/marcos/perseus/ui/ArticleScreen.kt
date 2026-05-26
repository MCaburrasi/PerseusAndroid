package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun ArticleScreen(
    viewModel: PerseusViewModel
){
    val picOfTheDay = viewModel.clientWrite("nwc")
    val picOfTheDayMap: Map<String, String> = picOfTheDay
        .split(",")
        .map { it.split("=") }
        .associate { it.first() to it.last() }

    Column(

    ) {
        picOfTheDayMap.get("title")?.let {
            Text(
                text= it,
                fontSize = 32.sp
            )
        }

        picOfTheDayMap.get("hdurl")?.let {
            AsyncImage(
                model = it,
                contentDescription = ""
            )
        }

        picOfTheDayMap.get("explanation")?.let {
            Text(
                text= it,
                fontSize = 32.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleScreenPreview(

){
    ArticleScreen(PerseusViewModel())
}