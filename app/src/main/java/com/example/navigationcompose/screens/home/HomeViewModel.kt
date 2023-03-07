package com.example.navigationcompose.screens.home

import androidx.lifecycle.ViewModel
import com.example.navigationcompose.navigation.Feature
import com.example.navigationcompose.navigation.NavCommand
import com.example.navigationcompose.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigationManager: NavigationManager
) : ViewModel() {

    fun navigateToScreenA(){
        val command = NavCommand.ScreenWithoutArguments(Feature.SCREEN_A)
        command.createDestinationRoute()
        navigationManager.navigate(command)
    }
}