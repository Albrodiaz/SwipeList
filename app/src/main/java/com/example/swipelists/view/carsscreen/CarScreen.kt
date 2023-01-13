package com.example.swipelists.view.carsscreen

import android.app.Activity
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.swipelists.domain.Car
import com.example.swipelists.shorToast
import kotlin.math.roundToInt

@Composable
fun CarScreen(vehicleViewModel: VehicleViewModel) {
    val activity = LocalContext.current as Activity
    val cars: List<Car> = vehicleViewModel.carList
    val isLoading: Boolean by vehicleViewModel.isLoading.observeAsState(true)
    LazyColumn(Modifier.fillMaxSize()) {
        if (!isLoading) {
            items(
                items = cars,
                key = { it.id!! }) { car ->
                ItemCar(
                    car = car,
                    deleteCar = { vehicleViewModel.deleteCar(car) },
                    showCar = { activity.shorToast("Ver: ${it.brand} ${it.model}") }
                )
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterialApi::class)
@Composable
fun ItemCar(car: Car, deleteCar: (Car) -> Unit, showCar: (Car) -> Unit) {
    val swipeableState = rememberSwipeableState(initialValue = 0)
    val width = 75.dp
    val sizePx = with(LocalDensity.current) { width.toPx() }
    Box(
        modifier = Modifier
            .height(140.dp)
            .padding(6.dp)
    ) {
        ActionsColumn(
            car = car,
            showCar = { showCar(car) },
            deleteCar = { deleteCar(car) }
        )
        Card(
            Modifier
                .zIndex(if (swipeableState.targetValue == 1) -1f else 1f)
                .swipeable(
                    state = swipeableState,
                    anchors = mapOf(0f to 0, -sizePx to 1),
                    thresholds = { _, _ -> FractionalThreshold(0.3f) },
                    orientation = Orientation.Horizontal
                )
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) },
            elevation = 6.dp,
            shape = RoundedCornerShape(9.dp)
        ) {
            Row {
                GlideImage(
                    model = car.photo,
                    contentDescription = "",
                    modifier = Modifier.width(120.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = car.brand.toString(), fontWeight = FontWeight.Bold)
                    Text(text = car.model.toString(), fontWeight = FontWeight.Bold)
                    Text(text = car.hp.toString() + " Cv", fontSize = 14.sp)
                    Text(text = car.motor.toString() + " Cc", fontSize = 14.sp)
                }
            }
        }
    }
}