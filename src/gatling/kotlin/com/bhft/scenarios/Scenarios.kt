package com.bhft.scenarios

import io.gatling.javaapi.core.CoreDsl.scenario
import com.bhft.feeders.Feeders.todoIdFeeder
import com.bhft.scenarios.Steps.createTodo

object Scenarios {
    val createTodosScenario =
        scenario("Create TODOs")
            .feed(todoIdFeeder)
            .exec(createTodo)
}
