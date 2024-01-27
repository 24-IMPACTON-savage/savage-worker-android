package team.retum.savage_android.feature.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nohjason.momori.application.SavageApp
import team.retum.savage_android.feature.onboarding.join.Join1Screen
import team.retum.savage_android.feature.onboarding.join.Join2Screen
import team.retum.savage_android.feature.onboarding.StartScreen
import team.retum.savage_android.feature.onboarding.join.Join3Screen
import team.retum.savage_android.feature.onboarding.login.Login1Screen
import team.retum.savage_android.feature.onboarding.login.Login2Screen


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
        composable(NavGroup.Onboarding.Join1.id) {
            Join1Screen(navController = navController)
        }
        composable(NavGroup.Onboarding.Join2.id + "/{name}") {
            val name = it.arguments?.getString("name")
            Join2Screen(navController = navController, name = name ?: "")
        }
        composable(NavGroup.Onboarding.Join3.id) {
            Join3Screen(navController = navController)
        }
        composable(NavGroup.Onboarding.Login2.id) {
            Login2Screen(navController = navController)
        }
        composable(NavGroup.Onboarding.Login1.id) {
            Login1Screen(navController = navController)
        }
    }
}

private val Start = NavGroup.Onboarding.Start

fun getStartDestination(enableAutoLogin: Boolean) =
    if (enableAutoLogin) NavGroup.Onboarding.Start.id else Start.id
