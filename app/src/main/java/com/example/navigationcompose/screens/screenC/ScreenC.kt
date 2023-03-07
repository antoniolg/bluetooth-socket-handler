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
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScreenC(message: String, unLuckyNumber: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Screen C",
            style = MaterialTheme.typography.h4,
        )
        Text(
            message,
            style = MaterialTheme.typography.h4,
        )
        Text(
            unLuckyNumber.toString(),
            style = MaterialTheme.typography.h4,
        )
        Text(
            "Last Screen",
            style = MaterialTheme.typography.h4,
        )
    }

}