package com.example.navigationcompose.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationcompose.bluetooth.BluetoothDataSource
import com.example.navigationcompose.navigation.Feature
import com.example.navigationcompose.navigation.NavCommand
import com.example.navigationcompose.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val bluetoothDataSource: BluetoothDataSource,
) : ViewModel() {
    init {
        viewModelScope.launch {
            bluetoothDataSource.events.collect { event ->
                Log.d("test screen home", event.name)
            }
        }
    }

    fun navigateToScreenA(){
        val command = NavCommand.ScreenWithoutArguments(Feature.SCREEN_A)
        command.createDestinationRoute()
        navigationManager.navigate(command)
    }
}