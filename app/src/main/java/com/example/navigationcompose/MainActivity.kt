package com.example.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.screens.Home
import com.example.navigationcompose.screens.ScreenA
import com.example.navigationcompose.screens.ScreenB
import com.example.navigationcompose.screens.ScreenC
import com.example.navigationcompose.ui.theme.NavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            Home {
                                navController.navigate("screen_a")
                            }
                        }
                        composable("screen_a") {
                            ScreenA {
                                navController.navigate("screen_b")
                            }
                        }
                        composable("screen_b") {
                            ScreenB {
                                navController.navigate("screen_c")
                            }
                        }
                        composable("screen_c") {
                            ScreenC()
                        }
                    }

                }
            }
        }
    }
}
