package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import segundo.caburrasi.marcos.perseus.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleBar(){
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        Modifier
            .shadow(8.dp)
    )
}