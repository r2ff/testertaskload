package com.bhft.model.config

data class LoadConfig(
    val intensity: Double = 200.0,
    val rampDuration: Long = 60,
    val stageDuration: Long = 1800,
    val atOnceUsers: Int = 1000,
    val stages: Int = 1
)
