package com.example.navigationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.navigationcompose.screens.Home
import com.example.navigationcompose.screens.ScreenA
import com.example.navigationcompose.screens.screenB.ScreenB
import com.example.navigationcompose.screens.ScreenC


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Feature.HOME.route) {
        homeNav()
        screenA()
        screenB()
        screenC()
    }
}

private fun NavGraphBuilder.homeNav() {
    composable(NavCommand.ScreenWithoutArguments(Feature.HOME)) {
        Home()
    }

}

private fun NavGraphBuilder.screenA() {
    composable(NavCommand.ScreenWithoutArguments(Feature.SCREEN_A)) {
        ScreenA()
    }
}

private fun NavGraphBuilder.screenB() {
    navigation(
        startDestination = NavCommand.ScreenB(Feature.SCREEN_B).route,
        route = Feature.SCREEN_B.route
    ) {
        composable(NavCommand.ScreenB(Feature.SCREEN_B)) { backStackEntry ->
            val luckyNumber = backStackEntry.arguments?.getInt("luckyNumber")
            requireNotNull(luckyNumber)
            ScreenB(luckyNumber)
        }
    }
}

private fun NavGraphBuilder.screenC() {
    navigation(
        startDestination = NavCommand.ScreenC(Feature.SCREEN_C).route,
        route = Feature.SCREEN_C.route
    ) {
        composable(NavCommand.ScreenC(Feature.SCREEN_C)) { backStackEntry ->
            val message = backStackEntry.arguments?.getString("message")
            val unLuckyNumber = backStackEntry.arguments?.getInt("unLuckyNumber")
            requireNotNull(message)
            requireNotNull(unLuckyNumber)
            ScreenC(message, unLuckyNumber)
        }
    }
}

private fun NavGraphBuilder.composable(
    navCommand: NavCommand,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navCommand.route,
        arguments = navCommand.args
    ) {
        content(it)
    }
}