package com.example.swipelists.view.mainscreen

import android.app.Activity
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.swipelists.R
import com.example.swipelists.shorToast

@Composable
fun MainTopAppBar() {
    //Variable context provisional
    val activity = LocalContext.current as Activity
    TopAppBar(
        title = { Text(text = "Garaje") },
        actions = {
            IconButton(onClick = {activity.shorToast("Añadir")}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Add car"
                )
            }
        }
    )
}