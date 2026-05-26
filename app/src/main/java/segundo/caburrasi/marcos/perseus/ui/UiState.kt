package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import segundo.caburrasi.marcos.perseus.Client
import segundo.caburrasi.marcos.perseus.data.ConfigUtils
import segundo.caburrasi.marcos.perseus.data.Post
import java.util.Properties

data class UiState (
    var newPostText: MutableState<String> = mutableStateOf(""),
    val client: Client = Client(ConfigUtils.getProperty("ip"), ConfigUtils.getProperty("port").toInt()),
    var posts: List<Post> = mutableListOf(),
    var newEventName: String = "",
    var newEventDesc: String = "",
    var loggedIn: Boolean = false,
    var usernameText: MutableState<String> = mutableStateOf(""),
    var passwordText: MutableState<String> = mutableStateOf(""),
    var showCreateAccount: Boolean = false,
    var showLogIn: Boolean = false,
    var showNoAccount: Boolean = true,
    var properties: Properties = Properties()
    )