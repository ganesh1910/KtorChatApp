package com.gk.ktorchatapp.domain.model

data class ChatState(
    val message: List<Message> = emptyList(),
    val isLoading: Boolean = false
)