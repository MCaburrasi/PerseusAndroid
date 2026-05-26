package segundo.caburrasi.marcos.perseus.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import segundo.caburrasi.marcos.perseus.ui.navigation.TabScreens

/* https://www.jetpackcompose.pro/tabs/tab/ */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: PerseusViewModel
){
    val selectedTab = remember { mutableIntStateOf(0) }

    Column(

    ) {
        SecondaryTabRow(
            selectedTabIndex = selectedTab.intValue
        ) {
            TabScreens.entries.forEachIndexed { index, screens ->
                Tab(
                    selected = selectedTab.intValue == index,
                    onClick = { selectedTab.intValue = index },
                    text = { Text(text = TabScreens.entries[index].name) }
                )
            }
        }

        when (selectedTab.intValue){
            0 -> MainPostScreen(Modifier, viewModel)
            1 -> EventScreen()
            2 -> ArticleScreen(viewModel = viewModel)
        }
    }

}

/*@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}*/