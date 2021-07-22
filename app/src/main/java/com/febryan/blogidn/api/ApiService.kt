package com.febryan.blogidn.api

import com.febryan.blogidn.model.ResponseBlog
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("list_artikel.php")
    fun getArtikel() : Call<ResponseBlog>

}