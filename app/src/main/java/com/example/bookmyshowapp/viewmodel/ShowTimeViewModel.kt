package com.example.bookmyshowapp.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookmyshowapp.data.ShowTimeRepository
import com.example.bookmyshowapp.model.Showtime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowTimeViewModel @Inject constructor(
    private val showRepository: ShowTimeRepository
) : ViewModel() {
    private val TAG = "ShowTimeViewModel"
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.d(TAG, throwable.message!!)
    }
    var isLoader = mutableStateOf(false)
    private var _showTime = listOf<Showtime>().toMutableStateList()

    init {
        initializeShowTime()
    }

    val showTime: List<Showtime>
        get() = _showTime

    private fun initializeShowTime() {
        isLoader.value = true
        viewModelScope.launch(exceptionHandler) {
            try {
                _showTime.clear()
                _showTime.addAll(showRepository.getShowDetails().toMutableStateList())
                isLoader.value = false
            } catch (e: Exception) {
                Log.d("viewModelScope", "Failed to fetch ShowTimings ${e.message}")
            }
        }
    }
}