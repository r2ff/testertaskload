package com.bhft.scenarios

import com.bhft.model.todo.TodoItem
import io.gatling.javaapi.core.CoreDsl
import io.gatling.javaapi.http.HttpDsl
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*
import kotlin.random.Random

object Steps {
    val createTodo =
        HttpDsl
            .http("Create TODO")
            .post(TODO)
            .body(
                CoreDsl.StringBody {
                    TodoItem(
                        id = it.getLong("id"),
                        text = UUID.randomUUID().toString(),
                        completed = Random.nextBoolean(),
                    ).run { Json.encodeToString(this) }
                },
            ).check(HttpDsl.status().shouldBe(201))
}
