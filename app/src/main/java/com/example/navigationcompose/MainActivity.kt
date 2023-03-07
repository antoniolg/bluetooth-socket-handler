package com.example.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                            val luckyNumberToSend = 7
                            ScreenA {
                                navController.navigate("screen_b/${luckyNumberToSend}")
                            }
                        }
                        composable(
                            route = "screen_b/{luckyNumber}",
                            arguments = listOf(
                                navArgument("luckyNumber") { type = NavType.IntType }
                            )
                        ) { backStackEntry ->
                            val luckyNumber = backStackEntry.arguments?.getInt("luckyNumber")
                            requireNotNull(luckyNumber)
                            val message = "Good bye"
                            val unLuckyNumber = 13
                            ScreenB(luckyNumber) {
                                navController.navigate("screen_c/${message}/${unLuckyNumber}")
                            }
                        }
                        composable(
                            route = "screen_c/{message}/{unLuckyNumber}",
                            arguments = listOf(
                                navArgument("message") { type = NavType.StringType },
                                navArgument("unLuckyNumber") { type = NavType.IntType }
                            )
                        ) { backStackEntry ->
                            val message = backStackEntry.arguments?.getString("message")
                            val unLuckyNumber = backStackEntry.arguments?.getInt("unLuckyNumber")
                            requireNotNull(message)
                            requireNotNull(unLuckyNumber)
                            ScreenC(message, unLuckyNumber)
                        }
                    }

                }
            }
        }
    }
}
