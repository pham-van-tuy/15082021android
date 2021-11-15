package com.example.learn09082021v001.fragmentLayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.learn09082021v001.R
import com.example.learn09082021v001.ReadAndWriteMemory


class FragmentListView : Fragment() {
    private var updateMemoriData = ReadAndWriteMemory()
    private val imgstudentlist = arrayListOf<Int>()
    private val namestudentlist = arrayListOf<String>()
    private val scorestudentlist = arrayListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listview, container, false)
        updateMemoriData.readDataMemory(context, "phamvantuy.txt")
        updatelistdata()
        val lvdata = view.findViewById<ListView>(R.id.lvdata)
        val listView = context?.let {
            AdapterListView(context = it,
                imgstudent = imgstudentlist,
                namestudent = namestudentlist,
                scorestudent = scorestudentlist)
        }
        lvdata.adapter = listView
        lvdata.setOnItemClickListener { adapterView, view, i, l ->
            imgstudentlist.removeAt(i)
            namestudentlist.removeAt(i)
            scorestudentlist.removeAt(i)

            context?.let {
                AdapterListView(context = it,
                    imgstudent = imgstudentlist,
                    namestudent = namestudentlist,
                    scorestudent = scorestudentlist)
                lvdata.adapter = listView
            }
        }

        return view
    }

    private fun updatelistdata() {
        imgstudentlist.add(R.drawable.androiicon)
        imgstudentlist.add(R.drawable.iosicon)
        namestudentlist.add(updateMemoriData.dataMemoryLine1)
        scorestudentlist.add(updateMemoriData.dataMemoryLine2)
        namestudentlist.add(updateMemoriData.dataMemoryLine3)
        scorestudentlist.add(updateMemoriData.dataMemoryLine4)
    }

}

