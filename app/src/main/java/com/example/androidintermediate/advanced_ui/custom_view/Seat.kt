package com.example.androidintermediate.advanced_ui.custom_view

data class Seat(
    var id: Int,
    var x: Float? = 0F,
    var y: Float? = 0F,
    var name: String,
    var isBooked: Boolean
)
