package com.example.tugaspraktikum.belajar.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.tugaspraktikum.belajar.navigation.ui.theme.TugasPraktikumTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasPraktikumTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profile: Profile,
    onNavigateToFriendsList: () -> Unit,
) {
    Column(modifier) {
        Text("Profile for ${profile.name}")
        Button(onClick = { onNavigateToFriendsList() }) {
            Text("Go to Friends List")
        }
    }
}

@Composable
fun FriendsListScreen(
    modifier: Modifier = Modifier,
    onNavigateToProfile: () -> Unit,
) {
    Column(modifier) {
        Text("Friends List")
        Button(onClick = { onNavigateToProfile() }) {
            Text("Go to Profile")
        }
    }
}

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    Card {
        Text("Settings")
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController, startDestination = Profile("John Smith")
    ) {
        composable<Profile> { backStackEntry ->
            val profile: Profile = backStackEntry.toRoute()
            ProfileScreen(
                profile = profile,
                onNavigateToFriendsList = {
                    navController.navigate(route = FriendsList)
                },
                modifier = modifier
            )
        }

        composable<FriendsList> {
            FriendsListScreen(
                onNavigateToProfile = {
                    navController.navigate(
                        route = Profile(name = "Aisha Devi")
                    )
                },
                modifier = modifier
            )
        }
    }
}

@Serializable
data class Profile(val name: String)

@Serializable
object FriendsList

@Serializable
object Settings