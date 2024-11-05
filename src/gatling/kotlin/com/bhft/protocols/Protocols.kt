package com.bhft.protocols

import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpProtocolBuilder
import com.bhft.config.gatlingConfig

object Protocols {
    val httpProtocol: HttpProtocolBuilder =
        http.baseUrl(gatlingConfig.service.baseUrl)
            .contentTypeHeader("application/json")
            .acceptHeader("*/*")
}
