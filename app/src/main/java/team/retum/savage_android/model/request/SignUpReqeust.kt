package team.retum.savage_android.model.request

data class SignUpRequest(
    val contact: String,
    val name: String,
    val address: String,
    val introduce: String,
    val country: String
)