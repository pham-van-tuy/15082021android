package com.example.learn09082021v001.ViewPager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.learn09082021v001.R

data class IntroSlide(val IMG: Int, val TITLE: String, val DESTCRIPTION: String)
class AdapterViewPager2RCV(
    private val introSlider: List<IntroSlide>, val onClickViewPager2: ActivityViewPager2Fragment
) : RecyclerView.Adapter<AdapterViewPager2RCV.IntroSlideViewHolder>() {
    inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgViewPager2: ImageView = view.findViewById(R.id.imgViewPager2)
        val tvTitle: TextView = view.findViewById(R.id.tvTitleViewPager2)
        val tvDestcription: TextView = view.findViewById(R.id.tvDestViewPager2)
        fun bind(introSlider: IntroSlide) {
            tvTitle.text = introSlider.TITLE
            tvDestcription.text = introSlider.DESTCRIPTION
            imgViewPager2.setImageResource(introSlider.IMG)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewpager2_item, parent, false)
        return IntroSlideViewHolder(view)

    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlider[position])
        holder.imgViewPager2.setOnClickListener {
            onClickViewPager2.onClickImgViewPager2(position)
        }
        holder.tvTitle.setOnClickListener {
            onClickViewPager2.onClickTitleViewPager2(position)
        }
        holder.tvDestcription.setOnClickListener {
            onClickViewPager2.onClickDesViewPager2(position)
        }

    }

    override fun getItemCount(): Int {
        return introSlider.size
    }

    interface viewPager2Onclick {
        fun onClickImgViewPager2(position: Int)
        fun onClickTitleViewPager2(position: Int)
        fun onClickDesViewPager2(position: Int)
    }


}
