package team.retum.savage_android.model.request

data class SignUpRequest(
    val contact: String,
    val name: String,
    val introduce: String,
    val country: String,
    val passport: String,
)