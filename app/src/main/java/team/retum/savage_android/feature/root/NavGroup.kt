package team.retum.savage_android.feature.root

sealed class NavGroup(val group: String) {
    sealed class Onboarding(val id: String) : NavGroup("onboarding") {
        data object Start: Onboarding(id = "start")
        data object Join0: Onboarding(id = "join0")
        data object Join1: Onboarding(id = "join1")
        data object Join2: Onboarding(id = "join2")
        data object Join3: Onboarding(id = "join3")
        data object Login1: Onboarding(id = "login1")
        data object Login2: Onboarding(id = "login2")
    }
}