package com.example.navigationcompose.bluetooth

import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton


// TODO 03 BLUETOOTH DATA SOURCE
// since it is just a PoC project, repositories are not needed
@Singleton
class BluetoothDataSource @Inject constructor() {
    var events = MutableStateFlow(EventStatus.BLUETOOTH_NOT_ENABLED)

    fun update(
        status: EventStatus
    ) {
        events.value = status
    }

}

enum class EventStatus{
    BLUETOOTH_NOT_ENABLED,
    COMPANION_NOT_INSTALLED,
    SERVICE_NOT_RUNNING,
    UNABLE_TO_PARSE_RESPONSE
}