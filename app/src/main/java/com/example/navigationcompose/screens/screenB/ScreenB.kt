package com.example.navigationcompose.screens.screenB

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ScreenB(luckyNumber:Int, viewModel: ScreenBViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Screen B",
            style = MaterialTheme.typography.h4,
        )
        Text(
            "Lucky Number: $luckyNumber",
            style = MaterialTheme.typography.h4,
        )
        Button(onClick = {viewModel.navigateToScreenC()}) {
            Text(text = "Go to Screen C")
        }
    }

}