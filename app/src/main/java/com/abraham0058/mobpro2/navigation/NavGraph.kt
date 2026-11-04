package com.abraham0058.mobpro2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abraham0058.mobpro2.ui.screen.detail.DetailScreen
import com.abraham0058.mobpro2.ui.screen.detail.KEY_ID_KELAS
import com.abraham0058.mobpro2.ui.screen.detail.KEY_NAMA_KELAS
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
        composable(route = Screen.Home.route) { MainScreen(navController, user) }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(KEY_ID_KELAS) { type = NavType.StringType },
                navArgument(KEY_NAMA_KELAS) { type = NavType.StringType }
            )
        ) { navBackStackEntry ->
            val args = navBackStackEntry.arguments
            val id = args?.getString(KEY_ID_KELAS) ?: ""
            val nama = args?.getString(KEY_NAMA_KELAS) ?: ""
            DetailScreen(navController, id, nama)
        }

    }

}