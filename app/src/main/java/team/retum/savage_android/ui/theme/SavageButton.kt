package team.retum.savage_android.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
internal fun SavageButton(
    modifier: Modifier = Modifier,
    color: Color = SavageColor.Gray100,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(color),
        enabled = enabled,
        onClick = onClick,
    ){

    }
}