package comtqbe.kotlincomposewithlivedata

import android.os.Bundle
import android.provider.CalendarContract.Events
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import comtqbe.kotlincomposewithlivedata.store.presentation.product_screen.ProductScreen
import comtqbe.kotlincomposewithlivedata.ui.theme.KotlinComposeWithLiveDataTheme
import comtqbe.kotlincomposewithlivedata.util.Event
import comtqbe.kotlincomposewithlivedata.util.EventBus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val lifecycleOwner = LocalLifecycleOwner.current.lifecycle
            LaunchedEffect(key1 = lifecycleOwner) {
                lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    EventBus.events.collect { event ->
                        when (event) {
                            is Event.Toast -> {
                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                }
            }
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductScreen()
                }
            }
        }
    }
}