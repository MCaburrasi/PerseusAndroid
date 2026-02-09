package segundo.caburrasi.marcos.perseus.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import segundo.caburrasi.marcos.perseus.R

@Composable
fun ToolCard(
    modifier: Modifier = Modifier
){
    Box(
        Modifier
            .clip(RoundedCornerShape(corner = CornerSize(12.dp)))
            .background(color = Color.Gray) /*TODO*/
    ) {
        Column(
            Modifier
                .padding(12.dp)
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
                Modifier
                    .fillMaxWidth(0.85f)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.size(8.dp))

            Text(
                text = stringResource(R.string.app_name),
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun ToolCardComposable(){
    ToolCard()
}