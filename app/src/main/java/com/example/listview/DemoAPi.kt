package com.example.listview

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object DemoApi {
    const val URL = "https://en.wikipedia.org/"

    object Model {
        data class Result(val query: Query)
        data class Query(val searchinfo: SearchInfo)
        data class SearchInfo(val totalhits: Int)
    }

    // https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=

    interface Service {
        @GET("w/api.php?action=query&format=json&list=search")
        suspend fun countHit(@Query("srsearch") name: String): Model.Result
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(Service::class.java)!!
}