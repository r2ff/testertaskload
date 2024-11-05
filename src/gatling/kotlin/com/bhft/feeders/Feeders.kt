package com.bhft.feeders

import java.util.UUID
import kotlin.random.Random

object Feeders {
    val todoIdFeeder =
        generateSequence {
            mapOf("id" to Random.nextLong(0, Long.MAX_VALUE))
        }.iterator()
}
