package comtqbe.kotlincomposewithlivedata.store.data.mapper

import android.net.http.HttpEngine
import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import arrow.core.Either
import comtqbe.kotlincomposewithlivedata.store.domain.model.ApiError
import comtqbe.kotlincomposewithlivedata.store.domain.model.NError
import java.io.IOException

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
fun Throwable.toNetworkError() : NError {
    val error = when(this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }

    return NError(
        error,
        this
    )
}