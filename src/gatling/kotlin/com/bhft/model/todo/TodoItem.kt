package com.bhft.model.todo

import kotlinx.serialization.Serializable

@Serializable
data class TodoItem(
    val id: Long,
    val text: String,
    val completed: Boolean
)
