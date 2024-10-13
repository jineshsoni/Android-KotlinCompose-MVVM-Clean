package comtqbe.kotlincomposewithlivedata.store.data.repo

import android.os.Build
import androidx.annotation.RequiresExtension
import arrow.core.Either
import comtqbe.kotlincomposewithlivedata.store.data.mapper.toNetworkError
import comtqbe.kotlincomposewithlivedata.store.data.remote.ProductApi
import comtqbe.kotlincomposewithlivedata.store.domain.model.NError
import comtqbe.kotlincomposewithlivedata.store.domain.model.Product
import comtqbe.kotlincomposewithlivedata.store.domain.repo.ProductsRepo
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(
    private val productApi: ProductApi
): ProductsRepo{
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getProduct(): Either<NError, List<Product>> {
        return Either.catch {
            productApi.getProducts()
        }.mapLeft {
            println("ERROR=====")
            println(it.toString())
            it.toNetworkError()
        }
    }
}