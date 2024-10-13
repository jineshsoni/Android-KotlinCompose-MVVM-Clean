package comtqbe.kotlincomposewithlivedata.store.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import comtqbe.kotlincomposewithlivedata.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvent(event: Any) {
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}