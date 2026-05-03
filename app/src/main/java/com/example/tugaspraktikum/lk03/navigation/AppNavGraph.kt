package com.example.tugaspraktikum.lk03.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugaspraktikum.lk03.ui.screen.DetailScreen
import com.example.tugaspraktikum.lk03.ui.screen.HomeScreen

@Composable
fun NavigationDemoApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home
    ) {
        composable(route = Routes.Home) {
            HomeScreen(
                modifier = modifier,
                onOpenDetail = { id ->
                    navController.navigate("${Routes.DetailBase}/$id")
                }
            )
        }

        composable(
            route = Routes.Detail,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
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