package com.example.learn09082021v001.fragmentLayout

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.learn09082021v001.MainActivity
import com.example.learn09082021v001.R
import kotlinx.android.synthetic.main.activity_framemt_layout.*


class ActivityFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_framemt_layout)
        ReplaceFragment(FragmentRecycleView ())
        btnRecycleViewFragment.setOnClickListener {
            ReplaceFragment(FragmentRecycleView ())
        }
        btnListViewFragment.setOnClickListener {
            ReplaceFragment(FragmentListView ())
        }
        btnHomeSW.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun ReplaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentLayout, fragment)
        fragmentTransition.commit()

    }
}