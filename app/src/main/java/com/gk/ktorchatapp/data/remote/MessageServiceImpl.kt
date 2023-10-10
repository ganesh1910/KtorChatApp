package com.gk.ktorchatapp.data.remote

import com.gk.ktorchatapp.data.remote.dto.MessageDto
import com.gk.ktorchatapp.domain.model.Message
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class MessageServiceImpl(
    val client: HttpClient
) : MessageService {
    override suspend fun getAllMessages(): List<Message> {
        return try {
            /*client.get<List<MessageDto>>(
                MessageService.EndPoints.GetAllMessages.url
            ).map {
                it.toMessage()
            }*/
            client.get {
                url(MessageService.EndPoints.GetAllMessages.url)
            }.body<List<MessageDto>>().map {
                it.toMessage()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}