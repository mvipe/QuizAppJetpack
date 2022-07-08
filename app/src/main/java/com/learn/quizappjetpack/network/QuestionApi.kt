package com.learn.quizappjetpack.network

import com.learn.quizappjetpack.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestion():Question{

    }
}