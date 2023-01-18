package com.example.swipelists.view.adddialog

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldNext(value: String, valueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = { valueChange(it) },
        label = { Text(text = label) },
        modifier = Modifier.padding(6.dp),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Words,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        )
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldDone(value: String, valueChange: (String) -> Unit, label: String) {
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = value,
        onValueChange = { valueChange(it) },
        label = { Text(text = label) },
        modifier = Modifier.padding(6.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        )
    )
}