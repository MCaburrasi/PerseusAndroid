package segundo.caburrasi.marcos.perseus.ui

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import segundo.caburrasi.marcos.perseus.Client
import segundo.caburrasi.marcos.perseus.data.Comment
import segundo.caburrasi.marcos.perseus.data.Event
import segundo.caburrasi.marcos.perseus.data.Post
import segundo.caburrasi.marcos.perseus.data.User
import java.util.Properties

data class UiState (
    var newPostText: MutableState<String> = mutableStateOf(""),
    val client: Client? = null,
    var posts: List<Post> = mutableListOf(),
    var newEventName: String = "",
    var newEventDesc: String = "",
    var loggedIn: Boolean = false,
    var usernameText: MutableState<String> = mutableStateOf(""),
    var passwordText: MutableState<String> = mutableStateOf(""),
    var showCreateAccount: Boolean = false,
    var showLogIn: Boolean = false,
    var showNoAccount: Boolean = true,
    var properties: Properties = Properties(),
    var isConnectedToServer: Boolean = false,
    var showChangeIp: Boolean = false,
    var newIp: String = "",
    var events: List<Event> = mutableListOf(),
    var likedList: List<Post> = mutableListOf(),
    var joinedList: List<Event> = mutableListOf(),
    var commentList: List<Comment> = mutableListOf(),
    var user: User? = null,

    var username: String = "",
    var password: String = "",
    var bio: String = "",

    var photoUri: Uri? = null
)