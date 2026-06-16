package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import segundo.caburrasi.marcos.perseus.R
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import coil3.Uri
import coil3.compose.AsyncImage
import kotlinx.coroutines.runBlocking
import segundo.caburrasi.marcos.perseus.data.ImageID
import segundo.caburrasi.marcos.perseus.network.PhotoAPI

@Composable
fun ProfileScreen(
    viewModel: PerseusViewModel
) {
    var clicked by remember { mutableStateOf(false) }

    if (!viewModel.uiState.collectAsState().value.loggedIn){
        CreateAccountPopup(viewModel)
    }

    Column(Modifier.fillMaxHeight()) {

        UserBanner(Modifier.align(Alignment.CenterHorizontally))

        viewModel.uiState.collectAsState().value.user?.name?.let {
            Text(
                text = it,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
        }

        Spacer(Modifier.size(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .height(1.dp)
        )

        Spacer(Modifier.size(12.dp))

        viewModel.uiState.collectAsState().value.user?.bio?.let {
            Text(
                text = it,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable(onClick = {clicked = !clicked})
                    .fillMaxWidth(0.85f),
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(Modifier.size(12.dp))
    }

    if (clicked){
        Dialog(
            onDismissRequest = {clicked = !clicked}
        ) {
            var text by remember {mutableStateOf("")}

            Column(
                Modifier
                    .clip(RoundedCornerShape(25))
                    .background(Color.White)
                    .padding(20.dp)
            ) {
                TextField(
                    value = text,
                    onValueChange = {newText -> text = newText},
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(Modifier.size(12.dp))

                Button(onClick = {
                    var bio = viewModel.clientWrite("Edit|Bio|$text")
                    viewModel.setBio(bio)
                    clicked = !clicked
                }) {
                    Text("Set bio")
                }
            }
        }
    }
}

@Composable
fun UserBanner(
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = stringResource(R.string.app_name),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(1.dp)
    )

    Box(
        modifier
    ) {
        Spacer(Modifier.size(12.dp))

        AsyncImage(
            model = runBlocking{PhotoAPI.retrofitService.getPfp(1)}, //runBlocking{PhotoAPI.retrofitService.getPhoto(ImageID("pfp", 1))},
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier
                .clip(CircleShape)
                .border(1.dp, Color.Black, CircleShape)
        )
    }

}

/*@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(

){
    ProfileScreen()
}*/