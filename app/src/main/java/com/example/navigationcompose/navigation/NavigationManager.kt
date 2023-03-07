package com.example.navigationcompose.navigation

import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {
    var commands = MutableStateFlow<NavCommand>(NavCommand.ScreenWithoutArguments(Feature.HOME))

    fun navigate(
        directions: NavCommand
    ) {
        commands.value = directions
    }
}