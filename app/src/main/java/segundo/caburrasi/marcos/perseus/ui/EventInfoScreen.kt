package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import segundo.caburrasi.marcos.perseus.R

@Composable
fun EventInfoScreen(

){
    Column (Modifier.fillMaxSize()) {
        Row (Modifier
            .fillMaxWidth(0.9f)
            .align(Alignment.CenterHorizontally)
        ) {
            Image(painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier.size(80.dp))

            Text(stringResource(R.string.app_name),
                fontSize = 40.sp,
                modifier = Modifier.align(Alignment.CenterVertically))
        }

        Button(onClick = {},
            Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(stringResource(R.string.app_name))
        }

        Row {
            Icon(imageVector = Icons.Rounded.DateRange,
                contentDescription = stringResource(R.string.app_name))

            Text(stringResource(R.string.app_name))
        }

        Row {
            Icon(imageVector = Icons.Rounded.Place,
                contentDescription = stringResource(R.string.app_name))

            Text(stringResource(R.string.app_name))
        }

        Row {
            Icon(imageVector = Icons.Rounded.Person,
                contentDescription = stringResource(R.string.app_name))

            Text(stringResource(R.string.app_name))
        }

        Text(stringResource(R.string.app_name))

        Text(stringResource(R.string.app_name))

        Text(stringResource(R.string.app_name))

        Text(stringResource(R.string.app_name))
    }
}

@Preview
@Composable
fun EventInfoScreenPreview(){
    EventInfoScreen()
}