package comtqbe.kotlincomposewithlivedata.store.presentation.product_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import comtqbe.kotlincomposewithlivedata.store.domain.repo.ProductsRepo
import comtqbe.kotlincomposewithlivedata.store.presentation.util.sendEvent
import comtqbe.kotlincomposewithlivedata.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsRepo: ProductsRepo
): ViewModel() {

    private val _state = MutableStateFlow(ProductViewState())
    val state = _state.asStateFlow()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            productsRepo.getProduct()
                .onRight {
                    products ->
                    _state.update {
                        it.copy(products = products)
                    }
                }.onLeft { error ->
                    _state.update {
                        it.copy(
                            error = error.error.message
                        )
                    }
                    sendEvent(Event.Toast(message = "Error"))
                }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}