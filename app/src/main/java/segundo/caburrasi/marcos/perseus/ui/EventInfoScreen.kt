package segundo.caburrasi.marcos.perseus.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import segundo.caburrasi.marcos.perseus.R
import segundo.caburrasi.marcos.perseus.data.Event
import androidx.compose.runtime.collectAsState

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventInfoScreen(
    event: Event,
    viewModel: PerseusViewModel
){
    Column (Modifier.fillMaxSize()){
        Row {
            Icon(imageVector = Icons.Rounded.DateRange,
                contentDescription = stringResource(R.string.app_name))

            Text(event.startDate.toString().split("T").joinToString(" / ") + " - " + event.endDate.toString().split("T").joinToString(" / "))
        }

        Row {
            Icon(imageVector = Icons.Rounded.Place,
                contentDescription = stringResource(R.string.app_name))

            Text(event.place)
        }

        Row {
            Icon(imageVector = Icons.Rounded.Person,
                contentDescription = stringResource(R.string.app_name))

            Text(event.author)
        }

        Text(event.description)

        Button(onClick = {
            viewModel.joinEvent(event.id)
            val joined = viewModel.uiState.value.client?.write("Load|Evat")
            viewModel.setJoinedList(joined)
        },
            Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally),

            enabled = viewModel.uiState.collectAsState().value.loggedIn && !viewModel.uiState.collectAsState().value.joinedList.contains(event)
        ) {
            Text("Join")
        }
    }
}

/*@Preview
@Composable
fun EventInfoScreenPreview(){
    EventInfoScreen()
}*/