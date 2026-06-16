package segundo.caburrasi.marcos.perseus.ui

import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import segundo.caburrasi.marcos.perseus.Client
import segundo.caburrasi.marcos.perseus.data.Comment
import segundo.caburrasi.marcos.perseus.data.ConfigUtils
import segundo.caburrasi.marcos.perseus.data.Event
import segundo.caburrasi.marcos.perseus.data.Post
import segundo.caburrasi.marcos.perseus.data.User
import java.time.LocalDateTime

class PerseusViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun sendPost(text: String): String{
        return uiState.value.client?.write(text) ?: String()
    }

    fun setPostsList(posts: String?){
        _uiState.update { currentState ->
            currentState.copy(
                posts = mutableListOf()
            )
        }

        val finalPosts = parsePostList(posts)

        _uiState.update { currentState ->
            currentState.copy(
                posts = finalPosts
            )
        }
    }

    fun parsePostList(posts: String?): List<Post>{
        var l: List<String>? = posts?.subSequence(1, posts?.length?.minus(1) ?: 0)?.split(", ")
        if (l?.get(0).equals("") == true || posts.equals("null")) l = null;
        var finalPosts: List<Post> = listOf()
        if (l != null) {
            for (s in l){
                finalPosts += parsePost(s)
            }
        }

        return finalPosts
    }

    fun parsePost(s: String): Post{
        val l: List<String> = s.split("|")
        var image = l[2]
        if (image == "null") image = ""
        return Post(l[0].toInt(), l[1], image, l[3])
    }

    fun clientWrite(s: String): String{
        return uiState.value.client?.write(s) ?: ""
    }

    fun connectToServer(){
        try {
            _uiState.update { currentState ->
                currentState.copy(
                    client = Client(ConfigUtils.getProperty("ip"), ConfigUtils.getProperty("port").toInt(), this),
                    isConnectedToServer = true
                )
            }

            uiState.value.client?.run()
            stopShowingNewIPPopup()
        } catch (e: Exception){
            _uiState.update { currentState ->
                currentState.copy(
                    showChangeIp = true
                )
            }
        }
    }

    fun stopShowingNewIPPopup(){
        _uiState.update { currentState ->
            currentState.copy(
                showChangeIp = false
            )
        }
    }

    fun updateNewIPText(s: String){
        _uiState.update { currentState ->
            currentState.copy(
                newIp = s
            )
        }
    }

    fun registerUser(userName: String, password: String){
        var user = clientWrite("Add|User|" + userName + "|" + password)
        var s = user.split("|")
        if (s[0].equals(userName)) {
            _uiState.update { currentState ->
                currentState.copy(
                    user = User(s[0], s[1], s[2], s[3], s[4])
                )
            }
        }

        if (user != "no"){
            setLoggedIn(true)
            confirmLogIn()
        }
    }

    fun logIn(userName: String, password: String){
        var user = clientWrite("Load|User|" + userName + "|" + password)
        var s = user.split("|")
        if (user != "no"){
            _uiState.update { currentState ->
                currentState.copy(
                    user = User(s[0], s[1], s[2], s[3], s[4])
                )
            }

            setLoggedIn(true)
            confirmLogIn()
        }
    }

    fun setLoggedIn(b:Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                loggedIn = b
            )
        }
    }

    fun confirmLogIn(){
        clientWrite("login|" + uiState.value.user?.name)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setEventsList(posts: String?){
        _uiState.update { currentState ->
            currentState.copy(
                events = mutableListOf()
            )
        }

        val finalEvent = parseEventList(posts)

        _uiState.update { currentState ->
            currentState.copy(
                events = finalEvent
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun parseEventList(posts: String?): List<Event>{
        var l: List<String>? = posts?.subSequence(1, posts?.length?.minus(1) ?: 0)?.split(", ")
        if (l?.get(0).equals("") == true || posts.equals("null")) l = null;
        var finalEvent: List<Event> = listOf()
        if (l != null) {
            for (s in l){
                finalEvent += parseEvent(s)
            }
        }

        return finalEvent
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun parseEvent(s: String): Event{
        val l: List<String> = s.split("|")
        var image = l[6]
        if (image == "null") image = ""
        return Event(l[0].toInt(), l[1], l[2], LocalDateTime.parse(l[3]), LocalDateTime.parse(l[4]), l[5], image, l[7], false)
    }

    fun joinEvent(e: Int){
        clientWrite("Add|Join|" + e)
    }

    fun likePost(e: Int){
        clientWrite("Add|Like|" + e)
    }

    fun setLikedList(posts: String?){
        _uiState.update { currentState ->
            currentState.copy(
                likedList = mutableListOf()
            )
        }

        val finalPosts = parsePostList(posts)

        _uiState.update { currentState ->
            currentState.copy(
                likedList = finalPosts
            )
        }
    }

    fun removeLike(p: Int){
        clientWrite("Del|Like|" + p)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setJoinedList(posts: String?){
        _uiState.update { currentState ->
            currentState.copy(
                joinedList = mutableListOf()
            )
        }

        val finalEvent = parseEventList(posts)

        _uiState.update { currentState ->
            currentState.copy(
                joinedList = finalEvent
            )
        }
    }

    fun setCommentList(comments: String?){
        _uiState.update { currentState ->
            currentState.copy(
                commentList = mutableListOf()
            )
        }

        val finalComments = parseCommentList(comments)

        _uiState.update { currentState ->
            currentState.copy(
                commentList = finalComments
            )
        }
    }

    fun parseCommentList(comments: String?):List<Comment>{
        var l: List<String>? = comments?.subSequence(1, comments?.length?.minus(1) ?: 0)?.split(", ")
        if (l?.get(0).equals("") == true || comments.equals("null")) l = null;
        var finalComment: List<Comment> = listOf()
        if (l != null) {
            for (s in l){
                finalComment += parseComment(s)
            }
        }

        return finalComment
    }

    fun parseComment(comment: String): Comment{
        val l: List<String> = comment.split("|")
        return Comment(l[0].toInt(), l[1], l[2])
    }

    fun writeComment(postId: String, content: String){
        clientWrite("Add|Comment|$postId|$content")
    }

    fun setBio(bio: String){
        _uiState.value.user?.bio = bio
    }

    fun setPhotoURI(uri: Uri?){
        _uiState.update { currentState ->
            currentState.copy(
                photoUri = uri
            )
        }
    }
}