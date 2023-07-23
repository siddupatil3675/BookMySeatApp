package com.example.bookmyshowapp.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bookmyshowapp.viewmodel.ShowTimeViewModel

@Composable
fun ShowLoader(showTimeViewModel: ShowTimeViewModel) {
    if (showTimeViewModel.isLoader.value) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        TheatreLayout(showTimeViewModel)
    }
}