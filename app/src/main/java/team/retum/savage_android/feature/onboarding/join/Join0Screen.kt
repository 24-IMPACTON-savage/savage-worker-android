package team.retum.savage_android.feature.onboarding.join

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import team.retum.savage_android.feature.root.NavGroup
import team.retum.savage_android.ui.component.SavageAppBar
import team.retum.savage_android.ui.component.SavageButton
import team.retum.savage_android.ui.component.SavageTextField
import team.retum.savage_android.ui.theme.SavageColor
import team.retum.savage_android.ui.theme.SavageTypography
import team.retum.savage_android.ui.theme.rememberKeyboardIsOpen

@Composable
private fun Title() {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp)
    ) {
        Text(
            text = "국가 및 언어를 선택해 주세요.",
            style = SavageTypography.HeadLine1
        )
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun Join0Screen(
    navController: NavController
) {

    var name by remember { mutableStateOf("") }
    val keyboardShow by rememberKeyboardIsOpen()

    SavageAppBar(
        callback = {
            navController.popBackStack()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            val itemsList = (0..50).toList()
            val itemModifier = Modifier
                .border(1.dp, Color.Blue)
                .padding(16.dp)
                .wrapContentSize()

            Title()
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ){
                items(itemsList){item ->
                    A(0, item.toString())
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            SavageButton(
                modifier = if (!keyboardShow) Modifier.padding(horizontal = 16.dp) else Modifier,
                onClick = {
                    if (name.isNotBlank()) {
                        navController.navigate(NavGroup.Onboarding.Join1.id)
                    } else {
                        // handling
                    }
                },
                text = "다음",
                isAbleClick = name.isNotBlank(),
                isKeyShow = keyboardShow
            )
            Spacer(modifier = Modifier.padding(bottom = 24.dp))
        }

    }

}

@Composable
fun A(image: Int, str: String){
    Column {
//        Image(
//            modifier = Modifier
//                .width(80.dp)
//                .height(80.dp)
//                .clip(CircleShape),
//            painter = painterResource(id = image), contentDescription = null)
        Text(text = str, style = SavageTypography.Body2)
    }
}