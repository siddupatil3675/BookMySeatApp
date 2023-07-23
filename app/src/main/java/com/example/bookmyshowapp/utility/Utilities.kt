package com.example.bookmyshowapp.utility

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
    return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        ?: false
}

fun visibilityPercent(isVisibility: Boolean, isSeatBooked: Boolean): Float {
    return if (isSeatBooked) {
        0.1f
    } else if (isVisibility) {
        1f
    } else {
        0f
    }
}
