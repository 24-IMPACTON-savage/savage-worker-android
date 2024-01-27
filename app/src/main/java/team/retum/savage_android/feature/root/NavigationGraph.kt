package team.retum.savage_android.feature.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
    NavHost(
        navController = navController,
        startDestination = NavGroup.Onboarding.Start.id,
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

fun getStartDestination() =
    /*if (enableAutoLogin) NavGroup.Main.MAIN.id else */Start.id
