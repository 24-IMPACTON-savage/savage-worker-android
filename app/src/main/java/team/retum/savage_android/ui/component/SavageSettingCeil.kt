package team.retum.savage_android.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import team.retum.savage_android.ui.theme.SavageColor
import team.retum.savage_android.ui.theme.SavageTypography

@Composable
fun SavageSettingCeil(
    title: String,
    isFrontArrow: Boolean = true,
    desc: String
//    callback: () -> Unit
) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Text(text = title, style = SavageTypography.Body2)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = desc, style = SavageTypography.Body2, color = SavageColor.Gray40)
        if (isFrontArrow) {
            Icon(modifier = Modifier.padding(start = 4.dp), tint = SavageColor.Gray40,imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
        }
    }
}