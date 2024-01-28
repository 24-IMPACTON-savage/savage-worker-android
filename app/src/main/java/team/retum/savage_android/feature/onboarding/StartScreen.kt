package team.retum.savage_android.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import team.retum.savage_android.R
import team.retum.savage_android.feature.root.NavGroup
import team.retum.savage_android.ui.component.SavageButton
import team.retum.savage_android.ui.theme.SavageColor
import team.retum.savage_android.ui.theme.SavageTypography
import team.retum.savage_android.ui.theme.savageClickable

@Composable
fun StartScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = 72.dp),
            text = "건강한 근로를 시작해 봐요!",
            style = SavageTypography.HeadLine1
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = "근로자용",
            style = SavageTypography.Body2,
            color = SavageColor.Primary40
        )

        Spacer(modifier = Modifier.weight(2f))
        Image(painter = painterResource(id = R.drawable.a), contentDescription = null)
        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier
                .scale(0.75f),
            painter = painterResource(R.drawable.image_simple_and_fast),
            contentDescription = null
        )

        // join button
        Text(
            style = SavageTypography.Body2,
            text = "회원가입 하기",
            color = SavageColor.Primary40,
            modifier = Modifier.savageClickable(
                rippleEnable = false,
            ) {
                // mv to join screen
                navController.navigate(NavGroup.Onboarding.Join0.id)
            }
        )
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        // login button
        SavageButton(
            modifier = Modifier.padding(horizontal = 16.dp),
            onClick = {
                      navController.navigate(NavGroup.Onboarding.Login1.id)
            },
            text = "로그인 하기",
            isAbleClick = true
        )
        Spacer(modifier = Modifier.padding(bottom = 24.dp))
    }

}