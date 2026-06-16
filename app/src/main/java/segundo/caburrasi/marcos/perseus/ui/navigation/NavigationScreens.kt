package segundo.caburrasi.marcos.perseus.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import segundo.caburrasi.marcos.perseus.R

enum class NavigationScreens (
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    HOME(icon = Icons.Rounded.Home, label = R.string.app_name),
    CREATE(icon = Icons.Rounded.Add, label = R.string.app_name)
}