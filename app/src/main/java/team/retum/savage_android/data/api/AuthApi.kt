package team.retum.savage_android.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import team.retum.savage_android.model.base.BaseResponse

interface AuthApi {

    @POST("auth/signin")
    suspend fun signIn(
        @Body request: SignInRequest
    ): BaseResponse<SignInResponse>

}

data class SignInRequest(
    val contact: String,
    val name: String
)

data class SignInResponse(
    val accesstoken: String,
    val expiredAt: String
)