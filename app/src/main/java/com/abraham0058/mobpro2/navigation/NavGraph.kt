package com.abraham0058.mobpro2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abraham0058.mobpro2.ui.screen.main.MainScreen
import com.google.firebase.auth.FirebaseUser

@Composable
fun SetupNavGraph(
    user: FirebaseUser,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) { MainScreen(user) }
    }
}