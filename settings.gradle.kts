pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://devrepo.kakao.com/nexus/repository/kakaomap-releases/")
        google()
        mavenCentral()
    }
}

rootProject.name = "savage-android"
include(":app")
