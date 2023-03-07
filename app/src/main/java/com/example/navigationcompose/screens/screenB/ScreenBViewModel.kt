package com.example.navigationcompose.screens.screenB

import androidx.lifecycle.ViewModel
import com.example.navigationcompose.navigation.Feature
import com.example.navigationcompose.navigation.NavCommand
import com.example.navigationcompose.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenBViewModel@Inject constructor(
    private val navigationManager: NavigationManager
) : ViewModel() {
    fun navigateToScreenC(){
        val unLuckyNumber = 13
        val message = "Good bye"
        val command = NavCommand.ScreenC(Feature.SCREEN_C)
        command.createDestinationRoute(message, unLuckyNumber)
        navigationManager.navigate(command)
    }
}