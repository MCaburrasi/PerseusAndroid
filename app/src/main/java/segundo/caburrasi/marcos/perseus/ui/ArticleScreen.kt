package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun ArticleScreen(
    viewModel: PerseusViewModel
){
    var picOfTheDay = viewModel.clientWrite("nwc")
    //picOfTheDay.subSequence(1, picOfTheDay.length);
    val picOfTheDayMap: Map<String, String> = picOfTheDay
        .split("|")
        .map { it.split("=") }
        .associate { it.first() to it.last() }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        picOfTheDayMap.get("title")?.let {
            Text(
                text= it,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(Modifier.size(12.dp))

        picOfTheDayMap.get("hdurl")?.let {
            AsyncImage(
                model = it,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .align(Alignment.CenterHorizontally)
            )
        }

        Spacer(Modifier.size(12.dp))

        picOfTheDayMap.get("explanation")?.let {
            Text(
                text= it,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Justify,

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