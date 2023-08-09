package com.example.navigationcompose.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationManager @Inject constructor() {
    var commands = MutableStateFlow<NavCommand>(NavCommand.ScreenWithoutArguments(Feature.HOME))

    fun navigate(
        directions: NavCommand
    ) {
        commands.value = directions
    }
}