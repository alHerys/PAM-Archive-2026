package com.example.tugaspraktikum.belajar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugaspraktikum.belajar.navigation.ui.screen.DetailScreen
import com.example.tugaspraktikum.belajar.navigation.ui.screen.HomeScreen

@Composable
fun NavgationDemoApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Routes.Home
    ) {
        composable(Routes.Home) {
            HomeScreen(
                modifier = modifier,
                onOpenDetail = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }

        composable(
            route = Routes.Detail,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailScreen(
                modifier = modifier,
                itemId = id,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

object Routes {
    const val Home = "Home"
    const val Detail = "detail/{id}"
    const val DetailBase = "detail"
}