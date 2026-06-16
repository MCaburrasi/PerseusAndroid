package segundo.caburrasi.marcos.perseus.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldLayout
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldState
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import segundo.caburrasi.marcos.perseus.ui.navigation.NavigationScreens


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    width: WindowWidthSizeClass,
    viewModel: PerseusViewModel
){

    val customNavSuiteType: NavigationSuiteType = when (width) {
        //TODO not work
        WindowWidthSizeClass.Medium -> {
            NavigationSuiteType.NavigationRail
        }
        WindowWidthSizeClass.Expanded -> {
            NavigationSuiteType.NavigationDrawer
        }
        WindowWidthSizeClass.Compact -> {
            NavigationSuiteType.NavigationBar
        }
        else -> {
            NavigationSuiteType.NavigationBar
        }
    }

    var currentDestination by rememberSaveable { mutableStateOf(NavigationScreens.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            NavigationScreens.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            stringResource(it.label)
                        )
                    },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it}
                )
            }
        },

        layoutType = customNavSuiteType,
        modifier = modifier
    ){
        when (currentDestination){
            NavigationScreens.HOME -> HomeScreen(viewModel)
            NavigationScreens.CREATE -> CreatePostOrEvent(Modifier, viewModel)
        }
    }
}