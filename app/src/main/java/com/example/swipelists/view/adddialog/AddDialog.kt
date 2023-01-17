package com.example.swipelists.view.adddialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.swipelists.ui.theme.Shapes
import com.example.swipelists.view.carsscreen.CarsViewModel

@Composable
fun AddDialog(carsViewModel: CarsViewModel, addViewModel: AddViewModel) {
    val brandText: String by addViewModel.brandText.observeAsState("")
    val modelText: String by addViewModel.modelText.observeAsState("")
    val hPower: String by addViewModel.horsePowerText.observeAsState("")
    val motorText: String by addViewModel.motorText.observeAsState("")
    val imageUrl: String by addViewModel.imageUrl.observeAsState("")
    val description: String by addViewModel.descriptionText.observeAsState("")
    val buttonActivated: Boolean by addViewModel.buttonActivated.observeAsState(false)

    Dialog(
        onDismissRequest = {
            carsViewModel.showDialog()
            addViewModel.clearForm()
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = true
        )
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(color = Color.White, shape = Shapes.small),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = brandText,
                label = { Text(text = "Marca") },
                onValueChange = { addViewModel.setCarForm(it, modelText, hPower, motorText, imageUrl) },
                modifier = Modifier.padding(6.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            OutlinedTextField(
                value = modelText,
                label = { Text(text = "Modelo") },
                onValueChange = { addViewModel.setCarForm(brandText, it, hPower, motorText, imageUrl) },
                modifier = Modifier.padding(6.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            OutlinedTextField(
                value = hPower,
                label = { Text(text = "Caballos") },
                onValueChange = { addViewModel.setCarForm(brandText, modelText, it, motorText, imageUrl) },
                modifier = Modifier.padding(6.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
            OutlinedTextField(
                value = motorText,
                label = { Text(text = "Motor") },
                onValueChange = { addViewModel.setCarForm(brandText, modelText, hPower, it, imageUrl) },
                modifier = Modifier.padding(6.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
            OutlinedTextField(
                value = imageUrl,
                label = { Text(text = "Url de la imagen") },
                onValueChange = { addViewModel.setCarForm(brandText, modelText, hPower, motorText, it) },
                modifier = Modifier.padding(6.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Uri,
                    imeAction = ImeAction.Next
                )
            )
            OutlinedTextField(
                value = description,
                onValueChange = { addViewModel.setCarForm(brandText, modelText, hPower, motorText, imageUrl, it) },
                label = { Text(text = "Descripción") },
                modifier = Modifier.padding(6.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )
            OutlinedButton(
                modifier = Modifier.padding(12.dp),
                onClick = {
                    carsViewModel.addCar(addViewModel.createCar())
                    carsViewModel.showDialog()
                    addViewModel.clearForm()
                },
                enabled = buttonActivated
            ) {
                Text(text = "Guardar")
            }
        }
    }
}