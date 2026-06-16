package segundo.caburrasi.marcos.perseus.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import segundo.caburrasi.marcos.perseus.R
import segundo.caburrasi.marcos.perseus.ui.components.EventPost
import segundo.caburrasi.marcos.perseus.ui.components.ImagePost

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventScreen(
    modifier: Modifier = Modifier,
    viewModel: PerseusViewModel
) {
    var events = viewModel.clientWrite("Load|Event")
    viewModel.setEventsList(events)

    if (viewModel.uiState.collectAsState().value.loggedIn){
        var joined = viewModel.uiState.collectAsState().value.client?.write("Load|Evat")
        viewModel.setJoinedList(joined)
    }

    Spacer(Modifier.size(12.dp))

    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        LazyColumn(
            Modifier.fillMaxWidth(0.95f)
                .align(Alignment.TopCenter)
        ) {
            items(
                items = viewModel.uiState.value.events
            ){ event ->
                EventPost(Modifier, event, viewModel)
            }
        }
    }
}

/*@Preview
@Composable
fun EventScreenPreview(){
    EventScreen()
}*/