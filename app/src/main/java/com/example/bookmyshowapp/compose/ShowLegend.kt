package com.example.bookmyshowapp.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Legend(enableBooking: Boolean) {
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            DisplayLegends()
        }
        Spacer(modifier = Modifier.height(2.dp))
        ShowBookingButton(enableBooking)
    }
}

@Composable
private fun DisplayLegends() {
    LegendBox(color = Color.Gray)
    Spacer(modifier = Modifier.width(4.dp))
    Text(
        "Sold",
    )

    Spacer(modifier = Modifier.width(16.dp))

    LegendBox(color = Color.White)
    Spacer(modifier = Modifier.width(4.dp))
    Text(
        "Available",
    )

    Spacer(modifier = Modifier.width(16.dp))

    LegendBox(color = Color.Green)
    Spacer(modifier = Modifier.width(4.dp))
    Text(
        "Selected",
    )
}

@Composable
private fun ShowBookingButton(enableBooking: Boolean) {
    Button(
        enabled = enableBooking,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        ),
        onClick = { },
        shape = ShapeDefaults.Small,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(start = 4.dp, end = 4.dp)
    ) {
        Text(text = if (enableBooking) "Book Tickets" else "Select 2 seats")
    }
}

@Composable
fun LegendBox(
    color: Color
) {
    Box(
        modifier = Modifier
            .size(20.dp)
            .border(
                width = 1.dp,
                color = if (color == Color.Gray) color else Color.Green
            )
            .background(color = color),
        contentAlignment = Alignment.Center
    ) {}

}