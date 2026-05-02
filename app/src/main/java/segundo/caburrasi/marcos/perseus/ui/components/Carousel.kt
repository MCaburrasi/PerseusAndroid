package segundo.caburrasi.marcos.perseus.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import segundo.caburrasi.marcos.perseus.R

@Composable
fun Carousel(
    modifier: Modifier = Modifier
){
    Column(
        modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier
                .height(200.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                ,
            contentScale = ContentScale.Crop
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {}
            ) {
                Text(stringResource(R.string.app_name))
            }

            Button(
                onClick = {}
            ) {
                Text(stringResource(R.string.app_name))
            }
        }
    }
}

@Preview
@Composable
fun CarouselPreview(

){
    Carousel()
}