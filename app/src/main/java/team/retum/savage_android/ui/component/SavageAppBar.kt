package team.retum.savage_android.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import team.retum.savage_android.ui.theme.SavageColor
import team.retum.savage_android.ui.theme.SavageTypography
import team.retum.savage_android.ui.theme.SavageandroidTheme
import team.retum.savage_android.ui.theme.savageClickable

@Composable
fun SavageAppBar(
    callback: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = SavageColor.White,
    tint: Color = SavageColor.Black,
    title: String? = null,
    content: @Composable () -> Unit
) {
    Column {
        Box {
            Row(
                modifier = modifier
                    .background(color = color)
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp)
                        .savageClickable(
                            rippleEnable = false
                        ) {
                            callback()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = null,
                        tint = tint,
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.CenterStart)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                title?.let {
                    Text(
                        text = it,
                        style = SavageTypography.Body2
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }

        content()
    }
}


@Preview
@Composable
fun AppBarPreview() {
    Surface(
        color = Color.White
    ) {
        SavageAppBar(callback = {

        }, title = "nice") {
            Text(text = "Hello")
        }
    }
}