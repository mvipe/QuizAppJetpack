package com.learn.quizappjetpack.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.quizappjetpack.data.DataOrException
import com.learn.quizappjetpack.model.QuestionItem
import com.learn.quizappjetpack.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository):ViewModel (){
    val data:MutableState<DataOrException<ArrayList<QuestionItem>,Boolean,Exception>> =mutableStateOf(
        DataOrException(null,true,Exception(""))
    )

    init {
        getAllQuestion()
    }

    private fun getAllQuestion(){
        viewModelScope.launch {
            data.value.loading = true
            data.value=repository.getAllQuestion()

            if(data.value.data.toString().isNotEmpty()){
                data.value.loading =false
            }
        }
    }
}