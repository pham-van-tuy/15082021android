package com.example.learn09082021v001

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class lvUpDateData (private var context: Context , var imgstudent : ArrayList <Int>,
                    var namestudent : ArrayList <String>,var scorestudent : ArrayList <String>): BaseAdapter() {
    override fun getCount( ): Int {
        // RETURN COUTN NUMBER ELEMENT
        return imgstudent.size
    }

    override fun getItem(p0: Int): Any {
        // RETURN POSITION
        return  p0

    }

    override fun getItemId(p0: Int): Long {
        // RETURN ID POSITION
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
         val   view = inflater.inflate(R.layout.lvmodelfilm,null , true)
        view.findViewById<ImageView>(R.id.imgStudent).setImageResource( imgstudent[p0])
        view.findViewById<TextView>(R.id.tvNameSudent).text = namestudent [p0]
        view.findViewById<TextView>(R.id.tvScoreSudent).text = scorestudent [p0]
        return view
    }
}
