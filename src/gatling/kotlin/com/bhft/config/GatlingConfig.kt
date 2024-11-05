package com.bhft.config

import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addResourceSource
import com.bhft.model.config.Config

val gatlingConfig =
    ConfigLoaderBuilder.default()
        .addResourceSource("/config.yaml")
        .build()
        .loadConfigOrThrow<Config>()