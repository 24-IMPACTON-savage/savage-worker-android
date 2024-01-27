package team.retum.savage_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import team.retum.savage_android.ui.component.SavageButton
import team.retum.savage_android.ui.theme.SavageandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SavageandroidTheme {
                SavageButton(onClick = {  },
                    isAbleClick = true)
            }
        }
    }
}
