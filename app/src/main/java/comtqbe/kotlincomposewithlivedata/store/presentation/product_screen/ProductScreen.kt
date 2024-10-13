package comtqbe.kotlincomposewithlivedata.store.presentation.product_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import comtqbe.kotlincomposewithlivedata.store.presentation.product_screen.ui.ProductCard
import comtqbe.kotlincomposewithlivedata.store.presentation.util.components.LoadingDialog
import comtqbe.kotlincomposewithlivedata.store.presentation.util.components.MyTopAppBar

@Composable
fun ProductScreen(
    viewState: ProductsViewModel = hiltViewModel()
) {
    val state = viewState.state.collectAsStateWithLifecycle()
    ProductContent(state = state.value)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductContent(
    state: ProductViewState
) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar(title = "Products")
        }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(state.products) {
                    item -> ProductCard(product = item, modifier = Modifier)
                }
        }
    }
}