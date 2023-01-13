package com.example.swipelists.view.carsscreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.*
import com.example.swipelists.domain.Car
import com.example.swipelists.repository.CarProvider

class VehicleViewModel(private val carProvider: CarProvider) : ViewModel() {
    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _carList = mutableStateListOf<Car>()
    val carList: List<Car> get() = _carList

    init {
        loadCars()
        _isLoading.value = false
    }

    fun deleteCar(car: Car) {
        carProvider.deleteCar(car)
        _carList.clear()
        loadCars()
    }

    private fun loadCars() {
        _carList.addAll(carProvider.getCars())
    }
}

@Suppress("UNCHECKED_CAST")
class CarViewModelFactory(private val carProvider: CarProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VehicleViewModel(carProvider) as T
    }
}