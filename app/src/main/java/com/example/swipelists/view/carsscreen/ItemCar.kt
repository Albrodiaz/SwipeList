package com.example.swipelists.view.carsscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.swipelists.domain.Car
import kotlin.math.roundToInt

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterialApi::class)
@Composable
fun ItemCar(car: Car, deleteCar: (Car) -> Unit, showCar: (Car) -> Unit) {
    val swipeableState = rememberSwipeableState(initialValue = 0) //0 colapsado, 1 expandido
    val width = 75.dp
    val sizePx = with(LocalDensity.current) { width.toPx() }

    Card(
        Modifier
            .zIndex(if (swipeableState.targetValue == 0) 1f else 0f)
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
                contentDescription = "Car picture",
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
    AnimatedVisibility(
        visible = swipeableState.targetValue == 1 && swipeableState.progress.fraction > 0.6,
        enter = fadeIn(animationSpec = tween(800)),
        exit = fadeOut(animationSpec = tween(1000))
    ) {
        ActionsColumn(
            car = car,
            showCar = { showCar(car) },
            deleteCar = { deleteCar(car) }
        )
    }
}

/*ANIMACION DE DESLIZAMIENTO


    AnimatedVisibility(
            visible = swipeableState.targetValue == 1 && swipeableState.progress.fraction > 0.7,
            enter = slideInHorizontally(animationSpec = tween(100), initialOffsetX = { 120 }),
            exit = slideOutHorizontally(animationSpec = tween(500), targetOffsetX = { 150 })
        ) {
            ActionsColumn(
                car = car,
                showCar = { showCar(car) },
                deleteCar = { deleteCar(car) }
            )
        }
*/