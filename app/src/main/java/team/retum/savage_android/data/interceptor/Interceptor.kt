package team.retum.savage_android.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import team.retum.savage_android.application.SavageApp

class Interceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${SavageApp.prefs.accessToken}")
            .build()
        val response = chain.proceed(request)
        return response
    }
}