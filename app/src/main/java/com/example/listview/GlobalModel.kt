package com.example.listview

import android.util.Log

object GlobalModel {
    val presidents: kotlin.collections.MutableList<President> = java.util.ArrayList()


    init {
        Log.d("USR","This ($this) is a singleton.")

        presidents.add(President("Kaarlo Stahlberg",1919, 1925, "Eka presidentti"))
        presidents.add(President("Lauri Rollander", 1925, 1931, "Toka Presidentti"))
        presidents.add(President("P.E.Svufhud", 1931, 1937, "Kolmas presidentti"))
        presidents.add(President("Kyösti Kallio", 1937, 1940, "Neljas presidentti"))
        presidents.add(President("Riisti Ryti", 1940, 1944, "Viides presidentti"))
    }
}