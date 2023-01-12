package com.example.swipelists.view.mainscreen

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun MainTopAppBar() {
    TopAppBar(
        title = { Text(text = "Garaje") }
    )
}