package com.example.learn09082021v001.fragmentLayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learn09082021v001.AdapterUpdateRcv
import com.example.learn09082021v001.R
import com.example.learn09082021v001.ReadAndWriteMemory

class FragmentRecycleView : Fragment(), AdapterUpdateRcv.OnclickRecycleView {
    private var updateMemoriData = ReadAndWriteMemory()
    private val imgstudentlist = arrayListOf<Int>()
    private val namestudentlist = arrayListOf<String>()
    private val scorestudentlist = arrayListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycleview, container, false)
        updateMemoriData.readDataMemory(context, "phamvantuy.txt")
        upDateDataRecycleView()
        upDateRecycleView(view)
        return view
    }

    fun upDateDataRecycleView() {
        if (updateMemoriData.dataMemoryLine1.isNotEmpty()) {
            imgstudentlist.add(R.drawable.androiicon)
            imgstudentlist.add(R.drawable.iosicon)
            namestudentlist.add(updateMemoriData.dataMemoryLine1)
            scorestudentlist.add(updateMemoriData.dataMemoryLine2)
            namestudentlist.add(updateMemoriData.dataMemoryLine3)
            scorestudentlist.add(updateMemoriData.dataMemoryLine4)
        }
    }

    fun upDateRecycleView(view: View) {
        val rcvlistdata = view.findViewById<RecyclerView>(R.id.rcvlistdata)
        rcvlistdata.layoutManager = LinearLayoutManager(context)
        rcvlistdata.setHasFixedSize(true)
        rcvlistdata.adapter = AdapterUpdateRcv(
            imgArrayArrayList = imgstudentlist,
            nameArrayString = namestudentlist,
            scoreArrayString = scorestudentlist, this
        )
    }

    override fun onClickImgRCV(imgArray: ArrayList<Int>, position: Int) {
        Toast.makeText(context, "IMGON CLICK" + position, Toast.LENGTH_SHORT).show()
        imgstudentlist.removeAt(position)
        namestudentlist.removeAt(position)
        scorestudentlist.removeAt(position)
        view?.let { upDateRecycleView(it) }
    }

    override fun onClickNameRCV(nameArray: ArrayList<String>, position: Int) {
        Toast.makeText(context, "NAME CLICK" + position, Toast.LENGTH_SHORT).show()
    }

    override fun onClickScoreRCV(scoreArray: ArrayList<String>, position: Int) {
        Toast.makeText(context, "SCORE CLICK" + position, Toast.LENGTH_SHORT).show()
    }

    override fun onClickOptionRCV(position: Int) {
        Toast.makeText(context, "OPTION CLICK" + position, Toast.LENGTH_SHORT).show()
    }
}


