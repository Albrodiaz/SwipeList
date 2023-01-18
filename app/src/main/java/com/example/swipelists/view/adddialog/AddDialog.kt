package com.example.swipelists.view.adddialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            carsViewModel.setDialogEnabled()
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
            TextFieldNext(
                value = brandText,
                valueChange = {addViewModel.setCarForm(it, modelText, hPower, motorText, imageUrl)},
                label = "Marca*" )
            TextFieldNext(
                value = modelText,
                valueChange = { addViewModel.setCarForm(brandText, it, hPower, motorText, imageUrl ) },
                label = "Modelo*")
            TextFieldNext(
                value = hPower,
                valueChange = { addViewModel.setCarForm(brandText, modelText, it, motorText, imageUrl ) },
                label = "Potencia*")
            TextFieldNext(
                value = motorText,
                valueChange = { addViewModel.setCarForm(brandText, modelText, hPower, it, imageUrl ) },
                label = "Motor*")
            TextFieldNext(
                value = imageUrl,
                valueChange = { addViewModel.setCarForm(brandText, modelText, hPower, motorText, it ) },
                label = "Url de imagen*")
            TextFieldDone(
                value = description,
                valueChange = { addViewModel.setDescription(it) },
                label = "Descripción")
            OutlinedButton(
                modifier = Modifier.padding(12.dp),
                onClick = {
                    carsViewModel.addCar(addViewModel.createCar())
                    carsViewModel.setDialogEnabled()
                    addViewModel.clearForm()
                },
                enabled = buttonActivated
            ) {
                Text(text = "Guardar")
            }
        }
    }
}