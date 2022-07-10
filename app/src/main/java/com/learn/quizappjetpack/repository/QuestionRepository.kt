package com.learn.quizappjetpack.repository

import com.learn.quizappjetpack.data.DataOrException
import com.learn.quizappjetpack.model.QuestionItem
import com.learn.quizappjetpack.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api:QuestionApi) {
    private val listOfQuestions=DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()
}