package com.example.learn09082021v001.ViewPager

import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.learn09082021v001.R
import com.example.learn09082021v001.ViewPage.ViewPagerZoom
import kotlinx.android.synthetic.main.activity_view_pager2_rcv.*


class ActivityViewPager2Fragment : AppCompatActivity(), AdapterViewPager2RCV.viewPager2Onclick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2_rcv)
        val adapterViewPager2RCV = AdapterViewPager2RCV(
            listOf(
                IntroSlide(
                    R.drawable.androiicon,
                    "Android",
                    "ANDROID student : pham van tuy"
                ),
                IntroSlide(
                    R.drawable.iosicon,
                    "IOS",
                    "IOS Student : pham dinh son"
                ),
                IntroSlide(
                    R.drawable.option,
                    "OPTION",
                    "OPTION swish"
                ),
                IntroSlide(
                    R.drawable.androiicon,
                    "Android",
                    "ANDROID student : pham van tuy"
                ),
                IntroSlide(
                    R.drawable.iosicon,
                    "IOS",
                    "IOS Student : pham dinh son"
                ),
                IntroSlide(
                    R.drawable.option,
                    "OPTION",
                    "OPTION swish"
                )
            ), this
        )
    //    val viewPager2RCV = findViewById<ViewPager2>(R.id.viewPager2RCV)
        viewPager2RCV.adapter = adapterViewPager2RCV
        viewPager2RCV.setPageTransformer(ViewPagerZoom())
//        val fragments :ArrayList<Fragment> = arrayListOf(
//            viewpager01 (),viewpager02 (),viewpager03()
//        )
//        var adapters =  AdapterViewPager2(fragments,this)
//        viewPagerFragment.adapter = adapters
    }

    override fun onClickImgViewPager2(position: Int) {
        Toast.makeText(this, "IMG VIEWPAGER2 onclick + $position", Toast.LENGTH_SHORT).show()
    }

    override fun onClickTitleViewPager2(position: Int) {
        Toast.makeText(this, "TITLE VIEWPAGER2 onclick + $position", Toast.LENGTH_SHORT).show()
    }

    override fun onClickDesViewPager2(position: Int) {
        Toast.makeText(this, "Destcription VIEWPAGER2 onclick + $position", Toast.LENGTH_SHORT)
            .show()
    }


}



