package segundo.caburrasi.marcos.perseus.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import segundo.caburrasi.marcos.perseus.ui.components.ToolCard

@Composable
fun ToolScreen(
    modifier: Modifier = Modifier
){
    Box(modifier = modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 140.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.align(Alignment.TopCenter)
                .fillMaxWidth(0.95f)
        ) {
            items(
                count = 6,
                itemContent = { ToolCard() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToolScreenPreview(){
    ToolScreen()
}