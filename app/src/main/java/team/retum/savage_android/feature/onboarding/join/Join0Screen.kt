package team.retum.savage_android.feature.onboarding.join

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import org.jetbrains.annotations.Async
import team.retum.savage_android.feature.root.NavGroup
import team.retum.savage_android.ui.component.SavageAppBar
import team.retum.savage_android.ui.component.SavageButton
import team.retum.savage_android.ui.component.SavageTextField
import team.retum.savage_android.ui.theme.SavageColor
import team.retum.savage_android.ui.theme.SavageTypography
import team.retum.savage_android.ui.theme.rememberKeyboardIsOpen
import team.retum.savage_android.ui.theme.savageClickable

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

data class Country(
    val image: String,
    val title: String
)

private val data = arrayListOf(
    Country(image = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Flag_of_Japan.svg/255px-Flag_of_Japan.svg.png",
        title = "japan"),
    Country(image = "https://mono.aks.ac.kr/s/media/05/058c61e6-b2c4-4cdf-b4a1-8915e5b24331.jpg?preset=page",
        title = "korea"),
    Country(image = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQLQ5VaV5Scbt1rWgLuq352uYuxTSgcUGqOzCXQFNctCW1S8Ci5y1cMMEaV04-0",
        title = "central african republic"),
    Country(image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSp9Fa30l6-LILOzmGJgIhlHoXEqrz58om0GWvb1QPDmM2k0VW8Sbrd9J8N_diE",
        title = "Afghanistan"),
    Country(image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-0DeoIaD3SDiDVg9r8fAC3vjSJHlHhG3bK_9CajdIqmUn5vXfz9MmKb7T9cO8",
        title = "Bangladesh"),
    Country(image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrrzv9JlMQY7TNnvY0j7ns2N13nlzAJWy-qo8U-_Zpu7pK3lAlig50bxzr_2BE",
        title = "Bahrain",),
    Country(image = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ0c5uxYnGUxmoRiRZ_dGJsjnV9vbYdp_xVLVeWnOaqgtrF9VCQYf2uKkK3PeYE",
        title = "butane"),
    Country(image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlInOKkmIdv7ZedCyy7_-iPSmUSt19x-iOgiY6zzgYLlk4I9oay0wcoCnB9hzH",
        title = "Democratic Republic of Congo"),
    Country(image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkNMjFfF6Rp6RKJhklW4JsnBkZQf_XrPFQa5kkBXJjuOzylQYUwxiBnyeYuTbA",
        title = "Democratic Republic of Laos"),
    Country(image = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcR3B-CC7ZVcXEJUugPMLgBklC2ocWz43QeN6XW-t0gJR5o7rLGZEgWxtzWnwXxq",
        title = "Democratic Republic of Vietnam"),
    Country(image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTW1PN5rPB3I1avfJGA65sg9UaV4H0E3AMDbyv27mWyWHah94lh3gELooq2JNww",
        title = "Sri Lanka"),
    Country(image = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ_KbF_JVaK2NCrnbY6xJCHiP2gtH1IqwKa006MODpFZl9ST-8WzIhiXwaQxZcE",
        title = "malaysia"),
    Country(image = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSW5dG5TX1DATsd-8PqLwpiTteOOcZ06ns44gVHNqwNYZdHKiK-q6wqZwQESai_",
        title = "Belgium"),
    Country(image = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQMwC8XDCDePoMMgF6AZen04rYiQ6eHJMNrianppvb9X1Ekue0ltHtXpQZJH72P",
        title = "Estonia"),
    Country(image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1mjga1J9NOryo-IbJunal8cpfePGCO6vidSncrhAaEuLgLE9FCv6xk22cGzET",
        title = "Lithuania")
)

@SuppressLint("SuspiciousIndentation")
@Composable
fun Join0Screen(
    navController: NavController
) {

    var country by remember {
        mutableStateOf<Country?>(null)
    }

    SavageAppBar(
        callback = {
            navController.popBackStack()
        }
    ) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Title()
                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .padding(top = 20.dp),
                    columns = GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    items(data) { item ->
                        A(item) {
                            country = item
                        }
                    }
                }
            }
            Column {
                Spacer(modifier = Modifier.weight(1f))
                SavageButton(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    onClick = {
                        if (country != null) {
                            navController.navigate(NavGroup.Onboarding.Join1.id + "/${country?.title}")
                        } else {
                            // handling
                        }
                    },
                    text = "다음",
                    isAbleClick = country != null,
                )
                Spacer(modifier = Modifier.padding(bottom = 24.dp))
            }
        }
    }
}

@Composable
fun A(country: Country, callback: () -> Unit) {
    Column(
        modifier = Modifier.savageClickable(rippleEnable = false) {
            callback()
        }
    ) {
        AsyncImage(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                /*.clip(CircleShape)*/,
            model = country.image,
            contentDescription = null)
        Text(text = country.title, style = SavageTypography.Body1)
    }
}