package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import segundo.caburrasi.marcos.perseus.R
import segundo.caburrasi.marcos.perseus.ui.components.EventPost
import segundo.caburrasi.marcos.perseus.ui.components.ImagePost

@Composable
fun EventScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {}
                ) {
                    Text(text = stringResource(R.string.place))
                }

                Button(
                    onClick = {}
                ) {
                    Text(text = stringResource(R.string.distance))
                }

                Button(
                    onClick = {}
                ) {
                    Text(text = stringResource(R.string.date))
                }
            }

            LazyColumn(
                Modifier.fillMaxWidth(0.95f)
                    .align(Alignment.CenterHorizontally)
            ) {
                items(
                    count = 30,
                    itemContent = {
                        EventPost(
                            Modifier
                                .padding(8.dp)
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun EventScreenPreview(){
    EventScreen()
}