package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import segundo.caburrasi.marcos.perseus.R
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun NewPostScreen(
    modifier: Modifier = Modifier,
    viewModel: PerseusViewModel
){
    var localText by remember { mutableStateOf(viewModel.uiState.value.newPostText.value) }

    Column (modifier = modifier.fillMaxSize()) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically)
            )

            TextField(
                value = localText,
                onValueChange = {newText -> localText = newText},
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(Modifier.size(12.dp))

        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 1f)
        )

        Spacer(Modifier.size(12.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {}) {
                Text(stringResource(R.string.app_name))
            }

            Button(onClick = {}) {
                Text(stringResource(R.string.app_name))
            }

            Button(onClick = {}) {
                Text(stringResource(R.string.app_name))
            }
        }

        Spacer(Modifier.size(88.dp))

        Button(
            onClick = {
                viewModel.sendPost("Add|Post|" + localText, "null")
                localText = ""
                      },
            Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(stringResource(R.string.app_name))
        }
    }
}

@Preview
@Composable
fun NewPostScreenPreview(){
    NewPostScreen(viewModel = PerseusViewModel())
}