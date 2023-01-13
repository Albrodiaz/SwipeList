package com.example.swipelists.view.carsscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.swipelists.domain.Car
import com.example.swipelists.repository.CarProvider

class VehicleViewModel(private val carProvider: CarProvider): ViewModel() {
    private val _cars = MutableLiveData<List<Car>>(emptyList())
    val cars: LiveData<List<Car>> get() = _cars
    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        _cars.postValue(carProvider.getCars())
        _isLoading.value = false
    }

    fun deleteCar(car: Car) {
        carProvider.deleteCar(car)
        _cars.value = carProvider.getCars()
    }
}

@Suppress("UNCHECKED_CAST")
class CarViewModelFactory(private val carProvider: CarProvider): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VehicleViewModel(carProvider) as T
    }
}