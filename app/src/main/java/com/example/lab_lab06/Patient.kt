package com.example.lab_06

import java.io.Serializable

data class Patient(
    var id: Int,
    var name: String,
    var age: Int,
    var diagnosis: String,
    var phoneNumber: String
) : Serializable
