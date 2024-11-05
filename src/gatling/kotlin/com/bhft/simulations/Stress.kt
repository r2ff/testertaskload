package com.bhft.simulations

import com.bhft.config.gatlingConfig
import com.bhft.protocols.Protocols.httpProtocol
import com.bhft.scenarios.Scenarios.createTodosScenario
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.Simulation

/**
 * The `Stress` class represents a stress test simulation using Gatling.
 * It sets up a scenario that gradually increases the load to test system performance
 * under stress conditions.
 */
class Stress : Simulation() {
    init {
        setUp(
            with(gatlingConfig.gatling.stress) {
                createTodosScenario.injectOpen(
                    rampUsersPerSec(0.0)
                        .to(intensity * 2)
                        .during(rampDuration),
                    constantUsersPerSec(intensity * 2)
                        .during(stageDuration),
                )
            },
        ).protocols(httpProtocol)
            .assertions(
                global().failedRequests().percent().lte(10.0), // Allow up to 10% failed requests
            )
    }
}
