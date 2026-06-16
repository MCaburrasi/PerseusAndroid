package segundo.caburrasi.marcos.perseus.ui

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup

@Composable
fun CreateAccountPopup(
    viewModel: PerseusViewModel
){
    var userText by remember { mutableStateOf(viewModel.uiState.value.usernameText.value) }
    var passText by remember { mutableStateOf(viewModel.uiState.value.passwordText.value) }

    Dialog (
        onDismissRequest = {}
    ) {
        Column(
            Modifier
                .clip(RoundedCornerShape(25))
                .background(Color.White)
                .padding(20.dp)
        ) {
            TextField(
                value = userText,
                onValueChange = { newText -> userText = newText },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.size(12.dp))

            TextField(
                value = passText,

                onValueChange = { newText -> passText = newText },

                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.size(12.dp))

            Row(
                Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(onClick = {
                    viewModel.registerUser(userText, passText)
                }) {
                    Text("Create Account")
                }

                Spacer(Modifier.size(12.dp))

                Button(onClick = {
                    viewModel.logIn(userText, passText)
                }) {
                    Text("Log In")
                }
            }

        }
    }
}

/*@Composable
@Preview
fun CreateAccountPopupPreview(

){
    CreateAccountPopup()
}*/