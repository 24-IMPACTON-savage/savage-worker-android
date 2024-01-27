
package team.retum.savage_android.model.base

data class BaseResponse<T>(
    val statusCode: Int,
    val statusMsg: String,
    val data: T?,
)