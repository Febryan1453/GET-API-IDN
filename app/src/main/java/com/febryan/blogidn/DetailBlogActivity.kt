package com.febryan.blogidn

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.febryan.blogidn.model.DataArtikelItem
import kotlinx.android.synthetic.main.activity_detail_blog.*
import kotlinx.android.synthetic.main.content_scrolling.view.*

class DetailBlogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_blog)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val dataArtikel = intent.getParcelableExtra<DataArtikelItem>("detail")
        if (dataArtikel != null){
            content_scrolling.tv_detail_isi.text = dataArtikel.isi

            Glide.with(this)
                .load(dataArtikel.gambar)
                .error(R.drawable.ic_launcher_background)
                .into(img_detail)
            toolbar_layout.title = dataArtikel.judul
        }

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}