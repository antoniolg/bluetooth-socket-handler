package com.example.navigationcompose.screens

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
import com.example.navigationcompose.screens.screenA.ScreenAViewModel

@Composable
fun ScreenA(viewModel: ScreenAViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Screen A",
            style = MaterialTheme.typography.h4,
        )
        Button(onClick = { viewModel.navigateToScreenB() }) {
            Text(text = "Go to Screen B")
        }
    }

}