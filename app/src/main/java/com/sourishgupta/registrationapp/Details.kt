package com.sourishgupta.registrationapp

import java.io.Serializable

data class Details(
    val title: String?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val password: String
) : Serializable