package com.febryan.blogidn.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiConfig {

    const val baseUrl = "http://192.168.70.200:8888/api_blog_idn/"

    fun getRetrofit() : Retrofit {
        //yang di bawah ini di ambil dari retrofit configurasi di dokumentasi retrofit
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiService{
        return getRetrofit().create(ApiService::class.java)
    }

//    seletah selesai disini lakukan dulu generete pojo yaa

}