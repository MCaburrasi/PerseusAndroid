package segundo.caburrasi.marcos.perseus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import segundo.caburrasi.marcos.perseus.ui.EventScreen
import segundo.caburrasi.marcos.perseus.ui.HomeScreen
import segundo.caburrasi.marcos.perseus.ui.NavBar
import segundo.caburrasi.marcos.perseus.ui.TitleBar
import segundo.caburrasi.marcos.perseus.ui.ToolScreen
import segundo.caburrasi.marcos.perseus.ui.theme.PerseusTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val width = calculateWindowSizeClass(this).widthSizeClass

            PerseusTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TitleBar() }
                ) { innerPadding ->
                    NavBar(Modifier.padding(innerPadding), width)
                }
            }
        }
    }
}