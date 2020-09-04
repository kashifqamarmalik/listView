package com.example.listview

class WebServiceRepository() {
    private val call = DemoApi.service

    suspend fun getHits(name: String) = call.countHit(name)


}