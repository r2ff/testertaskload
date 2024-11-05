package com.bhft.simulations

import com.bhft.config.gatlingConfig
import com.bhft.protocols.Protocols.httpProtocol
import com.bhft.scenarios.Scenarios.createTodosScenario
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.Simulation

/**
 * The `Performance` class represents a performance test simulation using Gatling.
 * It sets up a scenario to evaluate the system's performance under a controlled load,
 * ensuring that it meets the required performance benchmarks.
 */
class Performance : Simulation() {
    init {
        setUp(
            with(gatlingConfig.gatling.performance) {
                createTodosScenario.injectOpen(
                    rampUsersPerSec(0.0)
                        .to(intensity)
                        .during(rampDuration),
                    constantUsersPerSec(intensity)
                        .during(stageDuration)
                )
            }
        )
            .protocols(httpProtocol)
            .assertions(
                global().responseTime().mean().lte(500), // Mean response time should not exceed 500 ms
                global().successfulRequests().percent().gte(99.0) // Successful requests should be over 99%
            )
    }
}