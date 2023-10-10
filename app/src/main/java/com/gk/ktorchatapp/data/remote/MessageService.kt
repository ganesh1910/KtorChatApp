package com.gk.ktorchatapp.data.remote

import com.gk.ktorchatapp.domain.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object{
//        const val  BASE_URL ="http://10.0.2.2:8082"
//        const val  BASE_URL ="http://localhost:8082"
        const val  BASE_URL ="http://192.168.1.104:8082"
    }

    sealed class EndPoints(val url:String){
        object GetAllMessages:EndPoints("$BASE_URL/messages")
    }
}