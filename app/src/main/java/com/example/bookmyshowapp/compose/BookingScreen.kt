package com.example.bookmyshowapp.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookmyshowapp.ui.theme.BookMyShowAppTheme
import com.example.bookmyshowapp.viewmodel.ShowTimeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheatreLayout(showTimeViewModel: ShowTimeViewModel) {
    var enableBooking by remember { mutableStateOf(false) }
    BookMyShowAppTheme {
        Scaffold(
            bottomBar = {
                BottomAppBar(modifier = Modifier.height(80.dp)) {
                    Legend(enableBooking)
                }
            }
        ) { paddingValues ->
            Column(Modifier.padding(paddingValues)) {
                MovieDetails(showTimeViewModel.showTime)
                SeatLayout(showTimeViewModel.showTime) { toggleBooking ->
                    enableBooking = toggleBooking
                }
            }
        }
    }
}