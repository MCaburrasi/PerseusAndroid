package segundo.caburrasi.marcos.perseus.ui

import androidx.annotation.Nullable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import segundo.caburrasi.marcos.perseus.Client
import segundo.caburrasi.marcos.perseus.data.ConfigUtils
import segundo.caburrasi.marcos.perseus.data.Post

class PerseusViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun sendPost(text: String, image: String){
        uiState.value.client.write(text)
    }

    fun setPostsList(posts: String){
        val l: List<String> = posts.split(", ")
        var finalPosts: List<Post> = listOf()
        for (s in l){
            finalPosts += parsePost(s)
        }

        _uiState.update { currentState ->
            currentState.copy(
                posts = finalPosts
            )
        }
    }

    fun parsePost(s: String): Post{
        val l: List<String> = s.split("|")
        var image = l[2]
        if (image == "null") image = ""
        return Post(l[0].toInt(), l[1], image)
    }

    fun setShowCreateAccount(b: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                showCreateAccount = b,
                showNoAccount = false
            )
        }
    }

    fun setShowLogIn(b: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                showLogIn = b,
                showNoAccount = false
            )
        }
    }

    fun clientWrite(s: String): String{
        return uiState.value.client.write(s)
    }

    fun connectToServer(){
        _uiState.update { currentState ->
            currentState.copy(
                client = Client(ConfigUtils.getProperty("ip"), ConfigUtils.getProperty("port").toInt())
            )
        }

        uiState.value.client.run()
    }
}