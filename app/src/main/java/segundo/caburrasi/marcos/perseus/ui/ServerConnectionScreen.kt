package segundo.caburrasi.marcos.perseus.ui

import android.widget.Space
import android.widget.Spinner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import segundo.caburrasi.marcos.perseus.data.ConfigUtils

@Composable
fun ServerConnectionScreen(
    modifier: Modifier = Modifier,
    width: WindowWidthSizeClass,
    viewModel: PerseusViewModel
){
    if (!viewModel.uiState.collectAsState().value.isConnectedToServer){
        viewModel.connectToServer()
    }

    if (viewModel.uiState.collectAsState().value.showChangeIp){
        SetIPPopup(viewModel = viewModel)
    }

    if (viewModel.uiState.collectAsState().value.isConnectedToServer){
        NavBar(modifier, width, viewModel)
    }
}

@Composable
fun SetIPPopup(
    viewModel: PerseusViewModel,
    modifier: Modifier = Modifier
){
    Dialog(
        onDismissRequest = {}
    ) {
        Column(
            modifier
                .clip(RoundedCornerShape(25))
                .background(Color.White)
                .padding(20.dp)
        ) {
            TextField(
                value = viewModel.uiState.collectAsState().value.newIp,
                onValueChange = {newText -> viewModel.updateNewIPText(newText)},
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.size(12.dp))

            Button(onClick = {
                ConfigUtils.setIp(viewModel.uiState.value.newIp)
                viewModel.connectToServer()
            }) {
                Text("Set IP")
            }
        }
    }


}