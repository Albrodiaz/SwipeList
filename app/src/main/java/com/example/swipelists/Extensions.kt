package com.example.swipelists

import android.app.Activity
import android.widget.Toast

fun Activity.shorToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}