package com.example.learn09082021v001.NetworkComunicationRetrofit

import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.Body
import retrofit2.http.POST

interface InterfaceAPIRetrofit {
    var linkAPI: String

    @GET("/api/users")
//    @GET("/posts")   //new link
    fun getDataFromAPI(): Call<myDataRetrofit?>?

    @PUT("/api/users")
    // @PUT("/posts")   // new link
    fun upDataFromApi(@Body user: myDataRetrofit?): Call<myDataRetrofit?>?

    @POST("/api/users")
    fun upDateToRetrofit(@Body user: dataUpdateRetrofit?): Call<dataUpdateRetrofit?>?
}


