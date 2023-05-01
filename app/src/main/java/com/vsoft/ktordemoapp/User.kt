package com.vsoft.ktordemoapp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id")
    val id: String,
    @SerialName("firstName")
    val firstName: String,
    @SerialName("lastName")
    val lastName: String,
    @SerialName("email")
    val email: String,
    @SerialName("contactNumber")
    val contactNumber: String,
    @SerialName("age")
    val age: Int,
    @SerialName("dob")
    val dob: String,
    @SerialName("salary")
    val salary: Float,
    @SerialName("address")
    val address: String,
)