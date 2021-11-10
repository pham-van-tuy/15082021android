package com.example.learn09082021v001

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterUpdateLV(
    private var context: Context, var imgStudentArrayList: ArrayList<Int>,
    var nameStudentArrayString: ArrayList<String>, var scoreStudentArrayString: ArrayList<String>
) : BaseAdapter() {
    override fun getCount(): Int {
        // RETURN COUTN NUMBER ELEMENT
        return imgStudentArrayList.size
    }

    override fun getItem(p0: Int): Any {
        // RETURN POSITION
        return p0
    }

    override fun getItemId(p0: Int): Long {
        // RETURN ID POSITION
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.student_item, null, true)
        view.findViewById<ImageView>(R.id.imgStudent).setImageResource(imgStudentArrayList[p0])
        view.findViewById<TextView>(R.id.tvNameSudent).text = nameStudentArrayString[p0]
        view.findViewById<TextView>(R.id.tvScoreSudent).text = scoreStudentArrayString[p0]
        return view
    }
}
