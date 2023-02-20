package com.example.swipelists.view.carsscreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.*
import com.example.swipelists.domain.Car
import com.example.swipelists.repository.CarProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(
    private val carProvider: CarProvider
) : ViewModel() {

    private val _currentCar = MutableLiveData<Car>()
    val currentCar: LiveData<Car> get() = _currentCar

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _carList = mutableStateListOf<Car>()
    val carList: List<Car> get() = _carList

    private val _showDialog = MutableLiveData(false)
    val showDialog: LiveData<Boolean> get() = _showDialog

    init {
        loadCars()
        _isLoading.value = false
    }

    fun setCurrentCar(car: Car) {
        _currentCar.value = car
    }

    fun deleteCar(car: Car) {
        carProvider.deleteCar(car)
        _carList.remove(car)
    }

    fun addCar(car: Car) {
        carProvider.addCar(car)
        _carList.add(if (_carList.isEmpty()) 0 else 1, car)
    }

    private fun loadCars() {
        _carList.addAll(carProvider.getCars())
    }

    fun setDialogEnabled() {
        _showDialog.value = !showDialog.value!!
    }
}

/*
@Suppress("UNCHECKED_CAST")
class CarViewModelFactory(private val carProvider: CarProvider) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CarsViewModel(carProvider) as T
    }
}*/
