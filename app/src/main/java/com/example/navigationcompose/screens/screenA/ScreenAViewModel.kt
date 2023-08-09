package com.example.navigationcompose.screens.screenA

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
class ScreenAViewModel@Inject constructor(
    private val navigationManager: NavigationManager,
    private val bluetoothDataSource: BluetoothDataSource,
    ) : ViewModel() {

    init {
        viewModelScope.launch {
            bluetoothDataSource.events.collect { event ->
                Log.d("test screen A", event.name)
            }
        }
    }
    fun navigateToScreenB(){
        val luckyNumberToSend = 7

        val command = NavCommand.ScreenB(Feature.SCREEN_B)

        command.createDestinationRoute(luckyNumberToSend)
        navigationManager.navigate(command)
    }
}