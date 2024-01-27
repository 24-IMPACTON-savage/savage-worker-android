package team.retum.savage_android.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import team.retum.savage_android.model.base.BaseResponse
import team.retum.savage_android.model.request.SignUpRequest

interface UserApi {

    @POST("/user/worker")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest
    ): BaseResponse<Unit>

}