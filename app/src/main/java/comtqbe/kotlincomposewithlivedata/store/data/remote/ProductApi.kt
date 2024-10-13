package comtqbe.kotlincomposewithlivedata.store.data.remote

import comtqbe.kotlincomposewithlivedata.store.domain.model.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}