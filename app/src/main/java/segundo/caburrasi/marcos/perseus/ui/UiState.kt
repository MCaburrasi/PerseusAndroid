package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import segundo.caburrasi.marcos.perseus.Client

data class UiState (
    var newPostText: MutableState<String> = mutableStateOf(""),
    val client: Client = Client("192.168.5.220", 3621)
)