package team.retum.savage_android.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import team.retum.savage_android.ui.theme.SavageColor
import team.retum.savage_android.ui.theme.SavageTypography

@Composable
fun SavageTextField(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    showTitle: Boolean = false,
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
) {
    var focused by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (!showTitle && value.isEmpty()) 1f
        else 0f,
        label = "",
    )
    val color by animateColorAsState(
        targetValue = if (!focused) SavageColor.Gray40
        else if (isError) SavageColor.Red
        else SavageColor.Primary40,
        label = "",
    )
    val x by animateDpAsState(
        targetValue = if (focused && showTitle) (-12).dp
        else 0.dp,
        label = "",
    )
    val y by animateDpAsState(
        targetValue = if (focused && showTitle) (-52).dp
        else 0.dp,
        label = "",
    )
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 12.dp,
                    horizontal = 16.dp,
                ),
            contentAlignment = Alignment.CenterStart,
        ) {
            BasicTextField(
                modifier = Modifier.onFocusChanged {
                    focused = it.isFocused
                },
                value = value,
                onValueChange = onValueChange,
                textStyle = SavageTypography.Body3,
                singleLine = true,
                decorationBox = { it() },
            )
            Text(
                modifier = Modifier
                    .alpha(alpha)
                    .offset(
                        y = y,
                        x = x,
                    ),
                text = hint,
                color = color,
                style = SavageTypography.Body3
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = color,
        )
    }
}