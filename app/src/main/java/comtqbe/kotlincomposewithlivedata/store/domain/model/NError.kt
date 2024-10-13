package comtqbe.kotlincomposewithlivedata.store.domain.model

data class NError (
    val error: ApiError,
    val t: Throwable? = null
)

enum class ApiError(val message: String){
    NetworkError("Network Error"),
    UnknownError("Unknown Error"),
    UnknownResponse("Unknown Response")
}