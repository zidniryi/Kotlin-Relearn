package com.example.kotlinrelearn

import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinrelearn.ui.theme.KotlinRelearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login_screen", builder = {
                composable("login_screen"){
                    LoginScreen(navController)
                }
                composable("register_screen"){
                    RegisterScreen(navController)
                }
                composable("create_password_screen"){
                    CreatePasswordScreen(navController)
                }

                composable("feed_screen") {
                    FeedScreen(navController)
                }
                composable("profile_screen"){
                    ProfileScreen(navController)
                }


            })
        }
    }
}




