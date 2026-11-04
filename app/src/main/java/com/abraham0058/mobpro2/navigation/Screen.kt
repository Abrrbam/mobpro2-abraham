package com.abraham0058.mobpro2.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
}