package team.retum.savage_android.feature.surround

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import team.retum.savage_android.R
import team.retum.savage_android.feature.root.NavGroup
import team.retum.savage_android.ui.component.SavageButton
import team.retum.savage_android.ui.theme.SavageColor
import team.retum.savage_android.ui.theme.SavageTypography
import team.retum.savage_android.util.initMapView

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun SurroundScreen(
    navController: NavController
) {
    var title by remember { mutableStateOf("") }
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = { BottomSheet(title = title) },

        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box {
                AndroidView(
                    factory = {
                        initMapView(context = it) { address: String ->
                            title = address
                            coroutineScope.launch {
                                sheetState.show()
                            }
                        }
                    },
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 16.dp,
                                bottomEnd = 16.dp,
                            )
                        )
                        .background(SavageColor.Primary40),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                top = 60.dp,
                                bottom = 20.dp,
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "내 주변",
                            style = SavageTypography.HeadLine1,
                            color = SavageColor.White,
                        )
                        IconButton(onClick = {
                            navController.navigate(NavGroup.Main.Profile.id)
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_person),
                                contentDescription = null,
                                tint = SavageColor.White,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun BottomSheet(
    title: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        Text(
            modifier = Modifier.padding(
                top = 16.dp,
            ),
            text = title,
            style = SavageTypography.HeadLine1,
            color = SavageColor.Gray30,
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "기간",
            style = SavageTypography.Body2,
            color = SavageColor.Gray60,
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "12:00 ~ 13:00",
            style = SavageTypography.Body2,
            color = SavageColor.Gray60,
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "임금",
            style = SavageTypography.Body2,
            color = SavageColor.Gray60,
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "일 / 50,000원",
            style = SavageTypography.Body2,
            color = SavageColor.Gray60,
        )
        SavageButton(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 16.dp,
                )
                .navigationBarsPadding(),
            text = "지원하기",
            onClick = {},
            isAbleClick = true,
        )
    }
}