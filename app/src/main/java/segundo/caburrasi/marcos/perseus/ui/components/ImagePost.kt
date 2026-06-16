package segundo.caburrasi.marcos.perseus.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import segundo.caburrasi.marcos.perseus.ui.PerseusViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Dialog
import coil3.compose.AsyncImage
import okhttp3.internal.wait
import org.jetbrains.annotations.Async
import segundo.caburrasi.marcos.perseus.data.Comment
import segundo.caburrasi.marcos.perseus.data.ConfigUtils

@Composable
fun ImagePost(
    modifier: Modifier = Modifier,
    post: Post,
    viewModel: PerseusViewModel
){
    var whatIcon by remember { mutableStateOf(false) }
    var icon by remember { mutableStateOf(Icons.Default.Favorite) }
    var showComments by remember { mutableStateOf(false) }
    var writeComment by remember { mutableStateOf(false) }

    Box(modifier
        .clip(RoundedCornerShape(corner = CornerSize(12.dp))) /*TODO*/
        .clickable(onClick = {
            showComments = !showComments
            val comm = viewModel.clientWrite("Load|comment|" + post.id)
            viewModel.setCommentList(comm)
        })
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
                /*Image(
                    painter = painterResource(R.drawable.ic_launcher_background), /*TODO*/
                    contentDescription = "", /*TODO()*/
                    Modifier
                        .clip(CircleShape)
                        .fillMaxHeight()
                )*/

                Spacer(Modifier.weight(0.1f))

                Text(
                    text = post.author,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )

                Spacer(Modifier.weight(1f))
            }

            Spacer(Modifier.size(12.dp))

            if (post.image != ""){
                AsyncImage(
                    model = post.image + post.id,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(ratio = 1f)
                ) /*TODO*/
            }

            Spacer(Modifier.size(6.dp))

            Text(
                text = post.text,
            )

            Spacer(Modifier.size(6.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(
                    enabled = viewModel.uiState.collectAsState().value.loggedIn,
                    onClick = {
                        writeComment = !writeComment
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "",
                        Modifier.size(36.dp)
                    ) /*TODO*/
                }
            }
        }

        if (showComments){
            Dialog(
                onDismissRequest = {showComments = !showComments}
            ) {
                LazyColumn(
                    Modifier.fillMaxWidth(0.95f)
                        .align(Alignment.TopCenter)
                        .fillMaxHeight(0.8f)
                ) {
                    items(
                        items = viewModel.uiState.value.commentList
                    ){ comment ->
                        Comment(comment = comment)
                    }
                }
            }
        }

        var commentText by remember { mutableStateOf("") }

        if (writeComment){
            Dialog(
                onDismissRequest = {writeComment = !writeComment}
            ) {
                Column(
                    modifier
                        .clip(RoundedCornerShape(25))
                        .background(Color.White)
                        .padding(20.dp)
                ) {
                    TextField(
                        value = commentText,
                        onValueChange = {newText -> commentText = newText},
                        modifier = Modifier
                            .fillMaxWidth(0.95f)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(Modifier.size(12.dp))

                    Button(onClick = {
                        viewModel.writeComment(post.id.toString(), commentText)
                        writeComment = !writeComment
                    }) {
                        Text("Send")
                    }
                }
            }
        }
    }

    Spacer(Modifier.size(12.dp))
}

@Composable
fun Comment(
    comment: Comment
){
    Column (
        Modifier
            .clip(RoundedCornerShape(corner = CornerSize(12.dp)))
            .background(Color.White)
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row (
            Modifier
                .height(64.dp)
        ) {
            /*Image(
                painter = painterResource(R.drawable.ic_launcher_background), /*TODO*/
                contentDescription = "", /*TODO()*/
                Modifier
                    .clip(CircleShape)
                    .fillMaxHeight()
            )*/

            Spacer(Modifier.size(20.dp))

            Text(
                text = comment.author,
                fontSize = 20.sp
            )
        }

        Spacer(Modifier.size(20.dp))

        Text(
            text = comment.content
        )
    }

    Spacer(Modifier.size(12.dp))
}

/*@Composable
@Preview
fun ImagePostPreview(

){
    Comment()
}*/