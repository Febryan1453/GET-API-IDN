package com.febryan.blogidn

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.febryan.blogidn.model.DataArtikelItem

class BlogAdapter(val dataArtikel : List<DataArtikelItem?>?)
   : RecyclerView.Adapter<BlogAdapter.MyViewHolder> () {   // <-Setelah ketik ini Alt+Enter di BlogAdapter dan pilih tiga2nya

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imgJudul = view.findViewById<ImageView>(R.id.item_image_blog)
        val tvJudul = view.findViewById<TextView>(R.id.item_tv_judul)
        val tvPenulis = view.findViewById<TextView>(R.id.item_tv_penulis)
        val tvTanggal = view.findViewById<TextView>(R.id.item_tv_tanggal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_blog, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogAdapter.MyViewHolder, position: Int) {
        holder.tvJudul.text = dataArtikel?.get(position)?.judul
        holder.tvTanggal.text = dataArtikel?.get(position)?.tglPosting
        holder.tvPenulis.text = dataArtikel?.get(position)?.author

        Glide.with(holder.itemView)
            .load(dataArtikel?.get(position)?.gambar)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgJudul)

        //dibawh ini ditambahin untuk klik bolog yang dipih dan bakalan di intent / fokus aja dulu ama tampilin data blog di display
        //karena ini bukan halaman activity maka kita butuh bantuan context untuk mengintent
        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailBlogActivity::class.java)
            intent.putExtra("detail", dataArtikel?.get(position))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        if (dataArtikel != null){
            return  dataArtikel.size
        }
        return 0
    }

}