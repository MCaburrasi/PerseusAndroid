package segundo.caburrasi.marcos.perseus.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import segundo.caburrasi.marcos.perseus.R
import segundo.caburrasi.marcos.perseus.data.Post

@Composable
fun ImagePost(
    modifier: Modifier = Modifier,
    post: Post
){
    Box(modifier
        .clip(RoundedCornerShape(corner = CornerSize(12.dp))) /*TODO*/
    ) {
        Column(
            Modifier
                .background(Color.LightGray)
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background), /*TODO*/
                    contentDescription = "", /*TODO()*/
                    Modifier
                        .clip(CircleShape)
                        .fillMaxHeight()
                )

                Spacer(Modifier.weight(0.1f))

                Column {
                    Text(
                        text = stringResource(R.string.app_name),
                        fontSize = 20.sp
                    )

                    Text(
                        text = stringResource(R.string.app_name) + " - " + stringResource(R.string.app_name),
                        fontSize = 16.sp
                    )
                }

                Spacer(Modifier.weight(1f))

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "",
                    modifier = Modifier
                        .size(32.dp)
                )
            }

            Spacer(Modifier.size(12.dp))

            if (post.image != ""){
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(ratio = 1f)
                ) /*TODO*/
            }

            Spacer(Modifier.size(12.dp))

            Text(text = post.text)

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "",
                )

                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                ) /*TODO*/

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "",
                )
            }
        }
    }
}

/*@Composable
@Preview
fun ImagePostPreview(

){
    ImagePost()
}*/