package com.example.bookmyshowapp.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookmyshowapp.utility.visibilityPercent

@Composable
fun Seat(
    isSeatBooked: Boolean = false,
    isEnabled: Boolean = false,
    isSelected: Boolean = false,
    seatNumber: String = "",
    isValidSeat: Boolean,
    onClick: (Boolean, String, Boolean) -> Unit = { _, _, _ -> },
) {

    val seatColor = if (!isSeatBooked) {
        when {
            !isEnabled -> Color.White
            isSelected -> Green
            else -> Color.White
        }
    } else {
        Gray
    }

    val textColor = when {
        isSelected -> Color.White
        isSeatBooked -> Color.White
        else -> Green
    }

    val isClickable = when {
        isSeatBooked -> false
        !isValidSeat -> false
        else -> true
    }

    Box(modifier = Modifier
        .alpha(visibilityPercent(isValidSeat, isSeatBooked))
        .size(36.dp)
        .border(
            width = 1.dp,
            color = if (isSeatBooked) Gray else Green,
            shape = RoundedCornerShape(1.dp)
        )
        .clip(RoundedCornerShape(2.dp))
        .background(color = seatColor)
        .clickable(enabled = isClickable) {
            onClick(isSelected, seatNumber, isClickable)
        }
        .padding(2.dp),
        contentAlignment = Alignment.Center) {
        Text(
            text = seatNumber,
            color = textColor,
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}



