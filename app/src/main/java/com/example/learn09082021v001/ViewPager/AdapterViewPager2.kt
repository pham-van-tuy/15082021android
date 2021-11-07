package com.example.learn09082021v001.ViewPager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class AdapterViewPager2 (
    val item : ArrayList<Fragment>,
    activity :AppCompatActivity
    ) :FragmentStateAdapter (activity) {
    override fun getItemCount(): Int {
        return item.size
    }

    override fun createFragment(position: Int): Fragment {
       return item[position]
    }

}