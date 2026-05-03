package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PerseusViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun sendPost(text: String, image: String){
        uiState.value.client.write(text)
    }

    fun setNewPostText(text: String){
        _uiState.update { currentState ->
            currentState.copy(
                newPostText = mutableStateOf(text)
            )
        }
    }
}