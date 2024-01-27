package team.retum.savage_android.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import team.retum.savage_android.R

private val PretendardFamily = FontFamily(
    listOf(
        Font(
            resId = R.font.pretendard_bold,
            weight = FontWeight.Bold,
        ),
        Font(
            resId = R.font.pretendard_medium,
            weight = FontWeight.Medium,
        ),
        Font(
            resId = R.font.pretendard_semibold,
            weight = FontWeight.SemiBold,
        ),
    ),
)

private val platFormTextStyle = PlatformTextStyle(
    includeFontPadding = false,
)

object SavageTypography {
    val Title4 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 48.sp,
        platformStyle = platFormTextStyle,
    )

    val Title3 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 42.sp,
        platformStyle = platFormTextStyle,
    )

    val Title2 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp,
        platformStyle = platFormTextStyle,
    )

    val Title1 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 32.sp,
        platformStyle = platFormTextStyle,
    )

    val HeadLine3 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 36.sp,
        platformStyle = platFormTextStyle,
    )

    val HeadLine2 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 32.sp,
        platformStyle = platFormTextStyle,
    )

    val HeadLine1 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 28.sp,
        platformStyle = platFormTextStyle,
    )

    val Body4 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 28.sp,
        platformStyle = platFormTextStyle,
    )

    val Body3 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp,
        platformStyle = platFormTextStyle,
    )

    val Body2 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 22.sp,
        platformStyle = platFormTextStyle,
    )

    val Body1 = TextStyle(
        fontFamily = PretendardFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp,
        platformStyle = platFormTextStyle,
    )
}