package com.example.navigationcompose.screens.screenA

import androidx.lifecycle.ViewModel
import com.example.navigationcompose.navigation.Feature
import com.example.navigationcompose.navigation.NavCommand
import com.example.navigationcompose.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenAViewModel@Inject constructor(
    private val navigationManager: NavigationManager
) : ViewModel() {
    fun navigateToScreenB(){
        val luckyNumberToSend = 7

        val command = NavCommand.ScreenB(Feature.SCREEN_B)

        command.createDestinationRoute(luckyNumberToSend)
        navigationManager.navigate(command)
    }
}