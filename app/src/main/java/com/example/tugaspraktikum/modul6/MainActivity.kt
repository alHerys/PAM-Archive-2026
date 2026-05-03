package com.example.tugaspraktikum.modul6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.tugaspraktikum.modul6.navigation.Details
import com.example.tugaspraktikum.modul6.navigation.EditUsername
import com.example.tugaspraktikum.modul6.navigation.Home
import com.example.tugaspraktikum.modul6.navigation.Profile
import com.example.tugaspraktikum.modul6.ui.theme.TugasPraktikumTheme
import com.example.tugaspraktikum.modul6.view.AboutScreen
import com.example.tugaspraktikum.modul6.view.DetailScreen
import com.example.tugaspraktikum.modul6.view.EditUsernameScreen
import com.example.tugaspraktikum.modul6.view.HomeScreen
import com.example.tugaspraktikum.modul6.view.ProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            TugasPraktikumTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.padding(innerPadding), navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    var isSwitchChecked by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }

    NavHost(navController = navController, startDestination = Profile) {
        composable<Home> {
            HomeScreen(
                modifier = modifier,
                onNavigateToDetails = { id, name ->
                    navController.navigate(
                        Details(locationId = id, locationName = name)
                    )
                },
                isSwitchChecked = isSwitchChecked,
                onCheckedChange = { switchValue ->
                    isSwitchChecked = switchValue
                },
                name = name,
                onValueChange = { value ->
                    name = value
                },
                onNavigateToAbout = {
                    navController.navigate("about/$name")
                }
            )
        }

        composable<Details> { backStackEntry ->
            val args = backStackEntry.toRoute<Details>()
            DetailScreen(
                modifier = modifier,
                locationId = args.locationId,
                locationName = args.locationName,
                isPremium = isSwitchChecked,
                onBack = { navController.popBackStack() })
        }

        composable("about/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            AboutScreen(
                modifier = modifier,
                name = if (!name.isNullOrBlank()) name else "Anonim"
            )
        }

        composable<Profile> { backStackEntry ->
//             1. Observe the result from the SavedStateHandle
            val result by backStackEntry.savedStateHandle
                .getStateFlow(
                    key = "new_name",
                    initialValue = UserData(
                        name = "Anonymous",
                        birthPlace = "Unknown"
                    )
                ).collectAsState()

            ProfileScreen(
                modifier = modifier,
                userProfile = result,
                onEditClick = { navController.navigate(EditUsername) })
        }
        composable<EditUsername> {
            EditUsernameScreen(
                modifier = modifier,
                onCancel = {
                    navController.popBackStack()
                },
                onSave = { newName ->
                    // 2. Set the data into the PREVIOUS screen's handle
                    navController.previousBackStackEntry?.savedStateHandle?.set("new_name", newName)
                    // 3. Pop the screen to go back
                    navController.popBackStack()
                }
            )
        }
    }
}


