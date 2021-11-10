package com.example.learn09082021v001.fragmentLayout


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.learn09082021v001.R

class AdapterListView(
    private var context: Context, var imgstudent: ArrayList<Int>,
    var namestudent: ArrayList<String>, var scorestudent: ArrayList<String>,
) : BaseAdapter() {

    override fun getCount(): Int {
        return imgstudent.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.student_item, null, true)
        view.findViewById<ImageView>(R.id.imgStudent).setImageResource(imgstudent[p0])
        view.findViewById<TextView>(R.id.tvNameSudent).text = namestudent[p0]
        view.findViewById<TextView>(R.id.tvScoreStudent).text = scorestudent[p0]
        return view
    }
}