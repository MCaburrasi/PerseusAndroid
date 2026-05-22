package segundo.caburrasi.marcos.perseus.ui

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Popup

@Composable
fun ProfileScreen(
    viewModel: PerseusViewModel
) {

    if (!viewModel.uiState.collectAsState().value.loggedIn){
        CreateAccountPopup(viewModel)
    }

    Column(Modifier.fillMaxHeight()) {

        UserBanner(Modifier.align(Alignment.CenterHorizontally))

        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )

        Spacer(Modifier.size(12.dp))

        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            fontSize = 28.sp
        )

        Spacer(Modifier.size(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .height(1.dp)
        )

        HomeScreen(viewModel)

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
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
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