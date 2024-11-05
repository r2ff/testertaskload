package com.bhft.simulations

import com.bhft.config.gatlingConfig
import com.bhft.protocols.Protocols.httpProtocol
import com.bhft.scenarios.Scenarios.createTodosScenario
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.Simulation

/**
 * The `Stability` class represents a stability test simulation using Gatling.
 * It sets up a scenario to evaluate system performance under a steady load over time,
 * ensuring that the system remains stable and responsive.
 */
class Stability : Simulation() {
    init {
        setUp(
            with(gatlingConfig.gatling.stability) {
                createTodosScenario.injectOpen(
                    rampUsersPerSec(0.0)
                        .to(intensity)
                        .during(rampDuration),
                    constantUsersPerSec(intensity)
                        .during(stageDuration),
                )
            },
        ).protocols(httpProtocol)
            .assertions(
                global().responseTime().max().lte(500), // Max response time should not exceed 500 ms
                global().responseTime().percentile(95.0).lte(100), // 95th percentile response time should not exceed 100 ms
                global().failedRequests().percent().lte(1.0), // Allow up to 1% failed requests
            )
    }
}
