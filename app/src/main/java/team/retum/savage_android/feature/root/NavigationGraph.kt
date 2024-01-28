package team.retum.savage_android.feature.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import team.retum.savage_android.application.SavageApp
import team.retum.savage_android.feature.onboarding.StartScreen
import team.retum.savage_android.feature.onboarding.join.Join1Screen
import team.retum.savage_android.feature.onboarding.join.Join2Screen
import team.retum.savage_android.feature.onboarding.StartScreen
import team.retum.savage_android.feature.onboarding.join.Join0Screen
import team.retum.savage_android.feature.onboarding.join.Join3Screen
import team.retum.savage_android.feature.onboarding.login.Login1Screen
import team.retum.savage_android.feature.onboarding.login.Login2Screen
import team.retum.savage_android.feature.setting.SettingScreen
import team.retum.savage_android.feature.surround.SurroundScreen


@Composable
fun NavigationGraph(
    navController: NavHostController,
) {

    val accessToken = SavageApp.prefs.accessToken

    NavHost(
        navController = navController,
        startDestination = getStartDestination(enableAutoLogin = accessToken.isNotBlank()),
    ) {
        composable(NavGroup.Onboarding.Start.id) {
            StartScreen(navController = navController)
        }
        composable(NavGroup.Onboarding.Join0.id) {
            Join0Screen(navController = navController)
        }
        composable(NavGroup.Onboarding.Join1.id + "/{country}") {
            Join1Screen(
                navController = navController,
                country = it.arguments?.getString("country") ?: ""
            )
        }
        composable(NavGroup.Onboarding.Join2.id + "/{country}/{name}") {
            val name = it.arguments?.getString("name") ?: ""
            val country = it.arguments?.getString("country") ?: ""
            Join2Screen(navController = navController, name = name, country = country)
        }
        composable(NavGroup.Onboarding.Join3.id + "/{country}/{name}/{tel}") {
            val name = it.arguments?.getString("name") ?: ""
            val country = it.arguments?.getString("country") ?: ""
            val tel = it.arguments?.getString("tel") ?: ""
            Join3Screen(navController = navController, name = name, country = country, tel = tel)
        }
        composable(NavGroup.Onboarding.Login1.id) {
            Login1Screen(navController = navController)
        }
        composable(NavGroup.Onboarding.Login2.id + "/{name}") {
            val name = it.arguments?.getString("name") ?: ""
            Login2Screen(navController = navController, name = name)
        }
        composable(NavGroup.Main.Setting.id) {
            SettingScreen(navController = navController)
        }
        composable(NavGroup.Main.Surround.id) {
            SurroundScreen()
        }
    }
}

private val Start = NavGroup.Onboarding.Start

fun getStartDestination(enableAutoLogin: Boolean) =
    if (enableAutoLogin) NavGroup.Onboarding.Start.id else Start.id
