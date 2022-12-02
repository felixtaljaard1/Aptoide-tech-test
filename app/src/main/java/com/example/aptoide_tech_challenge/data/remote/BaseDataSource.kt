package com.example.aptoide_tech_challenge.data.remote

import com.example.aptoide_tech_challenge.utils.Resource
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return com.example.aptoide_tech_challenge.utils.Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        // Timber.d(message)
        return Resource.error("Network call has failed for a following reason: $message")
    }
}
