package com.bhft.simulations

import com.bhft.config.gatlingConfig
import com.bhft.protocols.Protocols.httpProtocol
import com.bhft.scenarios.Scenarios.createTodosScenario
import io.gatling.javaapi.core.CoreDsl.atOnceUsers
import io.gatling.javaapi.core.CoreDsl.global
import io.gatling.javaapi.core.Simulation

/**
 * The `Volume` class represents a load simulation using Gatling.
 * It sets up a scenario that creates tasks and tests system performance
 * under the simultaneous load of a large number of users.
 */
class Volume : Simulation() {
    init {
        setUp(
            with(gatlingConfig.gatling.volume) {
                createTodosScenario.injectOpen(
                    atOnceUsers(atOnceUsers), // Simultaneous load of a large number of users
                )
            },
        ).protocols(httpProtocol)
            .assertions(
                global().responseTime().max().lte(2000), // Max response time should not exceed 2 seconds
                global().successfulRequests().percent().gte(95.0), // Max response time should not exceed 2 seconds
            )
    }
}
