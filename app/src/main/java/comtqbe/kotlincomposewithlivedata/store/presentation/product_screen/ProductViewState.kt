package comtqbe.kotlincomposewithlivedata.store.presentation.product_screen

import comtqbe.kotlincomposewithlivedata.store.domain.model.Product

data class ProductViewState (
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)