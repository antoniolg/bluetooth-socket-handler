package com.example.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.bluetooth.BluetoothDataSource
import com.example.navigationcompose.bluetooth.EventStatus
import com.example.navigationcompose.navigation.Navigation
import com.example.navigationcompose.navigation.NavigationManager
import com.example.navigationcompose.ui.theme.NavigationComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Timer
import java.util.TimerTask
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigationManager: NavigationManager

    @Inject
    lateinit var bluetoothDataSource: BluetoothDataSource

    private val timer = Timer()
    private val task = object : TimerTask() {
        override fun run() {
            bluetoothDataSource.update(EventStatus.values().random())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        timer.scheduleAtFixedRate(task, 0, 5000)
        setContent {
            NavigationComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    navigationManager.commands.collectAsState().value.also { command ->
                        if (command.destinationRoute.isNotEmpty()) {
                            navController.navigate(command.destinationRoute)
                        }
                    }
                    Navigation(navController = navController)
                }
            }
        }
    }
}
