package segundo.caburrasi.marcos.perseus

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import segundo.caburrasi.marcos.perseus.data.ConfigUtils
import segundo.caburrasi.marcos.perseus.ui.NavBar
import segundo.caburrasi.marcos.perseus.ui.PerseusViewModel
import segundo.caburrasi.marcos.perseus.ui.TitleBar
import segundo.caburrasi.marcos.perseus.ui.theme.PerseusTheme
import java.util.Properties


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val width = calculateWindowSizeClass(this).widthSizeClass
            val policy = ThreadPolicy.Builder().permitAll().build()

            ConfigUtils.init(applicationContext)

            StrictMode.setThreadPolicy(policy)
            val viewModel = PerseusViewModel()
            viewModel.connectToServer()

            /*val posts = viewModel.uiState.collectAsState().value.client.write("Load|Post")
            viewModel.setPostsList(posts)*/

            PerseusTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TitleBar() }
                ) { innerPadding ->
                    NavBar(Modifier.padding(innerPadding), width, viewModel)
                }
            }
        }
    }
}