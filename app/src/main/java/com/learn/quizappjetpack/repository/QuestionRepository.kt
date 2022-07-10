package com.learn.quizappjetpack.repository

import android.util.Log
import com.learn.quizappjetpack.data.DataOrException
import com.learn.quizappjetpack.model.QuestionItem
import com.learn.quizappjetpack.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api:QuestionApi) {
    //listOfQuestions
    private val dataOrException=DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()

    suspend fun getAllQuestion() :DataOrException<ArrayList<QuestionItem>,Boolean,Exception>{
        try{
            dataOrException.loading=true
            dataOrException.data=api.getAllQuestion()
            if(dataOrException.data.toString().isNotEmpty()){
                dataOrException.loading=false
            }
        }catch (exception:Exception){
            dataOrException.e=exception
            Log.d("Exc","getAllQuestion: ${dataOrException.e!!.localizedMessage}")
        }

        return dataOrException
    }
}