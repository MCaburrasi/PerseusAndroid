package segundo.caburrasi.marcos.perseus.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import segundo.caburrasi.marcos.perseus.R

@Composable
fun EventPost(
    modifier: Modifier = Modifier
){
    Box(modifier
        .clip(RoundedCornerShape(corner = CornerSize(8.dp))) /*TODO*/
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp)
                .fillMaxWidth(0.85f)
                .height(60.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background), /*TODO*/
                contentDescription = "", /*TODO()*/
                Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
            )

            Spacer(Modifier.weight(0.1f))

            Column {
                Text(
                    text = stringResource(R.string.app_name),
                    fontSize = 28.sp
                )

                Text(
                    text = stringResource(R.string.app_name) + " - " + stringResource(R.string.app_name),
                    fontSize = 20.sp
                )
            }

            Spacer(Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
@Preview
fun EventPostPreview(

){
    EventPost()
}