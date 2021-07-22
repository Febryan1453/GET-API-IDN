package com.febryan.blogidn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.febryan.blogidn.api.ApiConfig
import com.febryan.blogidn.model.ResponseBlog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        ApiConfig.getService().getArtikel().enqueue(object : Callback<ResponseBlog>{
//            override fun onResponse(call: Call<ResponseBlog>, response: Response<ResponseBlog>) {
//                if (response.isSuccessful){
//                    val responseBlog = response.body()
//                    val msg = responseBlog?.message
//                    Log.d("MainActivity", msg ?: "")
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseBlog>, t: Throwable) {
//                Log.d("MainActivity", "onFailure" + t.localizedMessage)
//            }
//        })


        val tvError = findViewById<TextView>(R.id.tv_error)
        val rvBlog = findViewById<RecyclerView>(R.id.rv_blog)

        ApiConfig.getService().getArtikel().enqueue(object : Callback<ResponseBlog>{
            override fun onResponse(call: Call<ResponseBlog>, response: Response<ResponseBlog>) {
                if (response.isSuccessful){
                    val responseBlog = response.body()
                    val msg = responseBlog?.message
                    val dataArtikel = responseBlog?.dataArtikel

                    val blogAdapter = BlogAdapter(dataArtikel)

                    rvBlog.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        blogAdapter.notifyDataSetChanged()
                        adapter = blogAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBlog>, t: Throwable) {
                tvError.visibility = View.VISIBLE
                tvError.text = t.localizedMessage
            }
        })

    }
}