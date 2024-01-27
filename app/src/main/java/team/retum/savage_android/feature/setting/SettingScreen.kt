package team.retum.savage_android.feature.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import team.retum.savage_android.ui.component.SavageAppBar
import team.retum.savage_android.ui.component.SavageSettingCeil

@Composable
fun SettingScreen(
    navController: NavController
) {
    SavageAppBar(
        callback = {
            navController.popBackStack()
        },
        title = "설정"
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            SavageSettingCeil(title = "이름", desc = "도현욱")
            SavageSettingCeil(title = "여권 번호", desc = "123123 - ****23")
            SavageSettingCeil(title = "잔류 가능 일자", desc = "65일")
            SavageSettingCeil(title = "국가 및 언어", desc = "English")
        }
    }
}