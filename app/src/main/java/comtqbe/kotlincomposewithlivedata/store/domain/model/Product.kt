package comtqbe.kotlincomposewithlivedata.store.domain.model


data class Product(
    val id: Int,
    val description: String,
    val title: String,
    val image: String,
    val price: Double,
    val category: String,
    val rating: Rating
)

data class Rating(
    val rage: Double,
    val count: Int
)