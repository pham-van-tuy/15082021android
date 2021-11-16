package com.example.learn09082021v001.NetworkComunicationRetrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learn09082021v001.R
import com.squareup.picasso.Picasso
import java.util.ArrayList

class AdapterRCVretrofit(var myDataRCVView: ArrayList<DataForm>) :
    RecyclerView.Adapter<AdapterRCVretrofit.retrofitViewhoder>() {
    inner class retrofitViewhoder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAvatarRetrofit: ImageView = view.findViewById(R.id.imgAvatarRetrofit)
        val tvIDRetrofit: TextView = view.findViewById(R.id.tvIDRetrofit)
        val tvFirtNameRetrofit: TextView = view.findViewById(R.id.tvFirtNameRetrofit)
        val tvLastNameRetrofit: TextView = view.findViewById(R.id.tvLastNameRetrofit)
        val tvEmailRetrofit: TextView = view.findViewById(R.id.tvEmailRetrofit)
        fun bind(dataForm: DataForm) {
            tvIDRetrofit.text = dataForm.id.toString()
            tvFirtNameRetrofit.text = dataForm.first_name
            tvLastNameRetrofit.text = dataForm.last_name
            tvEmailRetrofit.text = dataForm.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): retrofitViewhoder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.retrofit_itemview, parent, false)
        return retrofitViewhoder(view)
    }

    override fun onBindViewHolder(holder: retrofitViewhoder, position: Int) {
        holder.bind(myDataRCVView[position])
        // load IMG from url
        val linkUrlAvarta = myDataRCVView[position].avatar
        val imgAvatarRetrofit: ImageView = holder?.itemView?.findViewById(R.id.imgAvatarRetrofit)
        Picasso.with(holder.itemView.context).load(linkUrlAvarta).into(imgAvatarRetrofit)
    }

    override fun getItemCount(): Int {
        return myDataRCVView.size
    }
}
