package com.example.bookmyshowapp.compose

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bookmyshowapp.model.Showtime

@Composable
fun SeatLayout(
    showList: List<Showtime>,
    enableBooking: (Boolean) -> Unit
) {
    val selectedSeat = remember {
        mutableStateListOf<String>()
    }
    // Showing only one theatre details
    val rows = showList[0].seatLayout.size
    val columns = showList[0].seatLayout[0].size
    val seatingDetails = showList[0].seatLayout
    val scrollStateHor = rememberScrollState()
    val scrollStateVer = rememberScrollState()
    Box(
        modifier = Modifier
            .horizontalScroll(
                scrollStateHor,
                reverseScrolling = true,
                enabled = true
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.verticalScroll(
                scrollStateVer,
                reverseScrolling = true,
                enabled = true
            )
        ) {
            // seat mapping
            var invalidRowIdAdjust = 0
            for (rowIndex in 0 until rows) {
                val invalidSeatIdAdjust = 0
                val isAnEmptyRow = if (seatingDetails[rowIndex][0].equals("EMPTY_ROW")) {
                    invalidRowIdAdjust++
                    true
                } else {
                    false
                }
                val adjustedRowId = rowIndex + 1 - invalidRowIdAdjust
                val rowId = "${(64 + adjustedRowId).toChar()}"
                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    DisplayRows(
                        columns,
                        seatingDetails,
                        rowIndex,
                        isAnEmptyRow,
                        rowId,
                        invalidSeatIdAdjust,
                        selectedSeat,
                        enableBooking
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun DisplayRows(
    columns: Int,
    seatingDetails: List<List<String>>,
    rowIndex: Int,
    isAnEmptyRow: Boolean,
    rowId: String,
    invalidSeatIdAdjust: Int,
    selectedSeat: SnapshotStateList<String>,
    enableBooking: (Boolean) -> Unit
) {
    var invalidSeatIdAdjust1 = invalidSeatIdAdjust
    for (columnIndex in 0 until columns) {

        val seatStatus = seatingDetails[rowIndex][columnIndex]
        var isSeatBooked = false
        var isValidSeat = true

        ShowRowId(columnIndex, isAnEmptyRow, rowId)

        when (seatStatus) {
            "AVAILABLE" -> isSeatBooked = false
            "BOOKED" -> isSeatBooked = true
            "EMPTY_ROW", "null" -> {
                invalidSeatIdAdjust1++
                isValidSeat = false
            }
        }
        val columnIdentity = ((columnIndex + 1) - invalidSeatIdAdjust1).toString()
        val seatNumber = "${rowId}${(columnIdentity)}"
        DisplaySeats(
            isSeatBooked,
            selectedSeat,
            seatNumber,
            isValidSeat,
            enableBooking
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
private fun ShowRowId(columnIndex: Int, isAnEmptyRow: Boolean, rowId: String) {
    if (columnIndex == 0) {
        if (isAnEmptyRow) {
            ShowRowID("-")
        } else {
            ShowRowID(rowId)
        }
    }
}

@Composable
private fun DisplaySeats(
    isSeatBooked: Boolean,
    selectedSeat: SnapshotStateList<String>,
    seatNumber: String,
    isValidSeat: Boolean,
    enableBooking: (Boolean) -> Unit
) {
    Seat(
        isSeatBooked = isSeatBooked,
        isEnabled = true,
        isSelected = selectedSeat.contains(seatNumber),
        seatNumber = seatNumber,
        isValidSeat = isValidSeat
    ) { selected, seat, isClickable ->
        if (isClickable) {
            if (selected) {
                selectedSeat.remove(seat)
                if (selectedSeat.size < 2) {
                    enableBooking(false)
                }
            } else {
                if (selectedSeat.size == 1) {
                    selectedSeat.add(seat)
                    enableBooking(true)
                } else if (selectedSeat.size >= 2) {
                    selectedSeat.clear()
                    selectedSeat.add(seat)
                    enableBooking(false)
                } else {
                    selectedSeat.add(seat)
                }
            }
        }
    }
}

@Composable
private fun ShowRowID(rowId: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(4.dp)
            .size(24.dp)
    ) {
        Text(
            text = rowId,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
    Spacer(modifier = Modifier.width(8.dp))
}