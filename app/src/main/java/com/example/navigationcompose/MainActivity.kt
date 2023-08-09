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
import com.socketmobile.capture.CaptureError
import com.socketmobile.capture.android.events.ConnectionStateEvent
import com.socketmobile.capture.client.CaptureClient
import com.socketmobile.capture.client.ConnectionState
import com.socketmobile.capture.client.DataEvent
import com.socketmobile.capture.client.DeviceClient
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.Timer
import java.util.TimerTask
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigationManager: NavigationManager

    @Inject
    lateinit var bluetoothDataSource: BluetoothDataSource

    // TODO 01
    // task to simulate the behavior of the bluetooth device, since it is only possible
    // to receive the events in the mainactivity
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

    //TODO 02 these are the events that are handling the bluetooth events
    // https://docs.socketmobile.com/capture/java/en/latest/android/getting-started.html#start-capture
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onData(event: DataEvent) {
        val device: DeviceClient = event.device
        val data: String = event.data.string
        // do something with data
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onCaptureServiceConnectionStateChange(event: ConnectionStateEvent) {
        val state: ConnectionState = event.state
        val client: CaptureClient = event.client
        if (state.hasError()) {
            val error: CaptureError = state.error

            when (error.code) {
                CaptureError.BLUETOOTH_NOT_ENABLED -> {

                }

                CaptureError.COMPANION_NOT_INSTALLED -> {


                }
                CaptureError.SERVICE_NOT_RUNNING -> {

                }

                CaptureError.UNABLE_TO_PARSE_RESPONSE -> {

                }
            }
        }
    }
}
