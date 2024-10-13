package comtqbe.kotlincomposewithlivedata.store.domain.repo

import arrow.core.Either
import comtqbe.kotlincomposewithlivedata.store.domain.model.NError
import comtqbe.kotlincomposewithlivedata.store.domain.model.Product

interface ProductsRepo {
    suspend fun getProduct(): Either< NError, List<Product>>
}