package com.example.swipelists.view.mainscreen

import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.swipelists.R

@Composable
fun MainTopAppBar() {
    //Variable context provisional
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = "Garaje") },
        actions = {
            IconButton(onClick = { Toast.makeText(context, "Añadir", Toast.LENGTH_SHORT).show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Add car"
                )
            }
        }
    )
}