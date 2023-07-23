## BookMySeatApp

This app demonstrates the following views and techniques:

* [Retrofit](https://square.github.io/retrofit/) to make API calls to an HTTP web service.
* [Jetpack Compose](https://developer.android.com/jetpack/compose/tutorial) Jetpack Compose is a modern toolkit for building native Android UI. 
* [MVVM](https://developer.android.com/topic/libraries/architecture/viewmodel) A software architectural pattern that promotes separation of concerns and enhances maintainability, testability, and reusability of code.
* [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android) Creates and manages dependencies.

The app demonstrates MVVM architecture with a modern UI toolkit, Jetpack Compose.
Seat rendering/mapping is retrieved from RESTFul APIs. 
The sitting arrangements follow the data model structure.
Shows available, booked, and selected seats.
Theatre seating arrangement updates dynamically from the API calls.


# Note
Change baseUrl in the file path (\app\src\main\java\com\example\bookmyshowapp\di) to test.
## Mock Sample API call
[
   {
      "movie":"Past Lives",
      "theatre":"PVR: Directors cut",
      "address":"Koramangala, Bangalore",
      "time":"2022-08-15 10:00 AM",
      "seatLayout":[
         [
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED"
         ],
         [
            "EMPTY_ROW",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null"
         ],
         [
            "null",
            "null",
            "null",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED",
            "BOOKED"
         ]
      ]
   }
]



