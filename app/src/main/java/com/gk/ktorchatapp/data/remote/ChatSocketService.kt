package com.gk.ktorchatapp.data.remote

import com.gk.ktorchatapp.domain.model.Message
import com.gk.ktorchatapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        username:String
    ): Resource<Unit>

    suspend fun sendMessage(message:String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    companion object{
        //        const val  BASE_URL ="http://10.0.2.2:8082"
//        const val  BASE_URL ="http://localhost:8082"
        const val  BASE_URL ="ws://192.168.1.104:8082"
    }

    sealed class EndPoints(val url:String){
        object ChatSocket:EndPoints("$BASE_URL/chat-socket")
    }
}