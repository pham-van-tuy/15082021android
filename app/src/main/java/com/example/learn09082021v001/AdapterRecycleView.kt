package com.example.learn09082021v001

import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learn09082021v001.fragmentLayout.FragmentRecycleView

class AdapterUpdateRcv(
    var imgArrayArrayList: ArrayList<Int>, var nameArrayString: ArrayList<String>,
    var scoreArrayString: ArrayList<String>, val onclickRCV: FragmentRecycleView
) : RecyclerView.Adapter<AdapterUpdateRcv.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgStudent: ImageView = view.findViewById(R.id.imgStudent)
        val nameStudent: TextView = view.findViewById(R.id.tvNameSudent)
        val scoreStudent: TextView = view.findViewById(R.id.tvScoreStudent)
        val optionImgRcv: ImageView = view.findViewById(R.id.imgOption)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgStudent.setImageResource(imgArrayArrayList[position])
        holder.scoreStudent.text = scoreArrayString[position]
        holder.nameStudent.text = nameArrayString[position]
        holder.imgStudent.setOnClickListener {
            onclickRCV.onClickImgRCV(imgArrayArrayList, position)
        }
        holder.nameStudent.setOnClickListener {
            onclickRCV.onClickNameRCV(nameArrayString, position)
        }
        holder.scoreStudent.setOnClickListener {
            onclickRCV.onClickScoreRCV(scoreArrayString, position)
        }
        holder.optionImgRcv.setOnClickListener {
            onclickRCV.onClickOptionRCV(position)
        }
    }

    override fun getItemCount(): Int {
        return imgArrayArrayList.size
    }

    interface OnclickRecycleView {
        fun onClickImgRCV(imgArray: ArrayList<Int>, position: Int)
        fun onClickNameRCV(nameArray: ArrayList<String>, position: Int)
        fun onClickScoreRCV(scoreArray: ArrayList<String>, position: Int)
        fun onClickOptionRCV(position: Int)
    }
}
