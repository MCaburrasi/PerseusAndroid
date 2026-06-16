package segundo.caburrasi.marcos.perseus.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import segundo.caburrasi.marcos.perseus.ui.navigation.CreatePostTab
import segundo.caburrasi.marcos.perseus.ui.navigation.TabScreens

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreatePostOrEvent(
    modifier: Modifier = Modifier,
    viewModel: PerseusViewModel
){
    if (!viewModel.uiState.collectAsState().value.loggedIn){
        CreateAccountPopup(viewModel)
    }

    val selectedTab = remember { mutableIntStateOf(0) }

    Column(

    ) {
        SecondaryTabRow(
            selectedTabIndex = selectedTab.intValue
        ) {
            CreatePostTab.entries.forEachIndexed { index, screens ->
                Tab(
                    selected = selectedTab.intValue == index,
                    onClick = { selectedTab.intValue = index },
                    text = { Text(text = TabScreens.entries[index].name) }
                )
            }
        }

        when (selectedTab.intValue){
            0 -> NewPostScreen(Modifier, viewModel)
            1 -> NewEventScreen(Modifier, viewModel)
        }
    }
}