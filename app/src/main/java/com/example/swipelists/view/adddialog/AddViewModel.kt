package com.example.swipelists.view.adddialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.swipelists.domain.Car

class AddViewModel : ViewModel() {

    private val _brandText = MutableLiveData("")
    val brandText: LiveData<String> get() = _brandText

    private val _modelText = MutableLiveData("")
    val modelText: LiveData<String> get() = _modelText

    private val _horsePowerText = MutableLiveData("")
    val horsePowerText: LiveData<String> get() = _horsePowerText

    private val _motorText = MutableLiveData("")
    val motorText: LiveData<String> get() = _motorText

    private val _imageUrl = MutableLiveData("")
    val imageUrl: LiveData<String> get() = _imageUrl

    private val _descriptionText = MutableLiveData("")
    val descriptionText: LiveData<String> get() = _descriptionText

    private val _buttonActivated = MutableLiveData(false)
    val buttonActivated: LiveData<Boolean> get() = _buttonActivated

    fun createCar(): Car {
        return Car(
            brand = _brandText.value,
            model = _modelText.value,
            hp = _horsePowerText.value,
            motor = _motorText.value,
            photo = _imageUrl.value,
            description = _descriptionText.value
        )
    }

    fun setCar(
        brand: String,
        model: String,
        hp: String,
        motor: String,
        image: String,
        description: String = ""
    ) {
        _brandText.value = brand
        _modelText.value = model
        _horsePowerText.value = hp
        _motorText.value = motor
        _imageUrl.value = image
        _descriptionText.value = description

        _buttonActivated.value =
            brand.isNotEmpty() && model.isNotEmpty() && hp.isNotEmpty() && motor.isNotEmpty() && image.isNotEmpty()
    }
}