package segundo.caburrasi.marcos.perseus.ui.components

import android.app.Dialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import segundo.caburrasi.marcos.perseus.R
import segundo.caburrasi.marcos.perseus.data.Event
import segundo.caburrasi.marcos.perseus.ui.EventInfoScreen
import segundo.caburrasi.marcos.perseus.ui.PerseusViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventPost(
    modifier: Modifier = Modifier,
    event: Event,
    viewModel: PerseusViewModel
){
    var expanded by remember {mutableStateOf(false)}

    Column(modifier
        .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
        .clickable(onClick = {expanded = !expanded})
        .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .fillMaxWidth(0.85f)
        ) {
            /*Image(
                painter = painterResource(R.drawable.ic_launcher_background), /*TODO*/
                contentDescription = "",
                Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
                    .size(84.dp)
            )*/

            Spacer(Modifier.size(16.dp))

            Text(
                text = event.title,
                fontSize = 28.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

        }

        if (expanded){
            EventInfoScreen(event, viewModel)
        }
    }

    Spacer(Modifier.size(12.dp))
}

/*@Composable
@Preview
fun EventPostPreview(

){
    EventPost()
}*/