package com.example.swipelists.domain

data class Car(
    val id: Long = System.currentTimeMillis(),
    val brand: String? = null,
    val model: String? = null,
    val hp: String? = null,
    val motor: String? = null,
    val photo: String? = null,
    val description: String? = null
)