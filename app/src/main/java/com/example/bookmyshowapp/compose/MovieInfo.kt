package com.example.bookmyshowapp.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookmyshowapp.model.Showtime

@Composable
fun MovieDetails(showTime: List<Showtime>) {
    // Showing only for one theatre now
    val movieDetails = showTime[0]
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 100.dp)
            .background(Color.Red)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShowMovieDetails(movieDetails)
        ShowTheatreDetails(movieDetails)
        ShowTimeDetails(movieDetails)
    }
}

@Composable
private fun ShowTimeDetails(movieDetails: Showtime) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = movieDetails.time,
            fontSize = 12.sp,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        OutlinedButton(
            onClick = {
            },
            modifier = Modifier
                .height(35.dp)
                .width(130.dp),
            border = BorderStroke(
                width = 1.dp,
                color = Color.White
            ),
            shape = ShapeDefaults.Small
        ) {
            Text(text = "2 Tickets", color = Color.White)
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
                onClick = { },
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit",
                    tint = Color.White,
                )
            }
        }
    }
}

@Composable
private fun ShowTheatreDetails(movieDetails: Showtime) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "${movieDetails.theatre} : ${movieDetails.address}",
            fontSize = 12.sp,
            color = Color.White,
            fontWeight = FontWeight.Normal
        )

    }
}

@Composable
private fun ShowMovieDetails(movieDetails: Showtime) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = movieDetails.movie,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        IconButton(
            onClick = { },
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close",
                tint = Color.White,
            )
        }

    }
}