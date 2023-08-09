package com.example.navigationcompose.screens.screenB

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
class ScreenBViewModel@Inject constructor(
    private val navigationManager: NavigationManager,
    private val bluetoothDataSource: BluetoothDataSource,
    ) : ViewModel() {

    init {
        viewModelScope.launch {
            bluetoothDataSource.events.collect { event ->
                Log.d("test screen B", event.name)
            }
        }
    }

    fun navigateToScreenC(){
        val unLuckyNumber = 13
        val message = "Good bye"
        val command = NavCommand.ScreenC(Feature.SCREEN_C)
        command.createDestinationRoute(message, unLuckyNumber)
        navigationManager.navigate(command)
    }
}