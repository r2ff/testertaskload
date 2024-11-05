package com.bhft.model.config

data class GatlingConfig(
    val performance: LoadConfig,
    val stability: LoadConfig,
    val stress: LoadConfig,
    val volume: LoadConfig
)
