package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_sub_bottom.view.*

const val DATA_TRANFER = "datatranfer"


class MainActivity : AppCompatActivity() {
    var scoreOOP = NameScoreOOP()
    private val imgstudentlist = arrayListOf<Int>()
    private val namestudentlist = arrayListOf<String>()
    private val scorestudentlist = arrayListOf<String>()


    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putSerializable(DATA_TRANFER, scoreOOP)
        checkDataFull()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        scoreOOP = savedInstanceState.getSerializable(DATA_TRANFER) as NameScoreOOP
        upDateDataMain()
        checkDataFull()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && resultCode == RESULT_OK) {
            scoreOOP = data.getSerializableExtra(DATA_TRANFER) as NameScoreOOP
            upDateDataMain()
            checkDataFull()
            updatelistdata()
            updateDataListView()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // view config
        viewMainAndroid.goneButtonAction()
        viewMainIos.goneButtonAction()
        btnStartReset.setOnClickListener {
            if (viewMainAndroid.dataEmpty() && viewMainIos.dataEmpty()) {
                val intent = Intent(this, DataInput::class.java)
                startActivityForResult(intent, 1)
            } else clearData()
            checkDataFull()
        }

        lvdata.setOnItemClickListener { adapterView, view, i, l ->
            imgstudentlist.removeAt(i)
            namestudentlist.removeAt(i)
            scorestudentlist.removeAt(i)
            updateDataListView()
        }
    }

    private fun upDateDataMain() {
        viewMainAndroid.edtName.setText(scoreOOP.NameInputandroid)
        viewMainAndroid.tvScore.text = scoreOOP.ScoreInPutandroid.toString()
        viewMainIos.edtName.setText(scoreOOP.NameInPutIOS)
        viewMainIos.tvScore.text = scoreOOP.ScoreInPutIOS.toString()
    }
// Funtion

    private fun checkDataFull() {
        if (viewMainAndroid.dataNotEmpty() || viewMainIos.dataNotEmpty()) {
            btnStartReset.setText("RESET")
        } else btnStartReset.setText("START")
    }

    private fun clearData() {
        viewMainAndroid.clear()
        viewMainIos.clear()
    }

    private fun updatelistdata() {
        imgstudentlist.add(R.drawable.androiicon)
        imgstudentlist.add(R.drawable.iosicon)
        namestudentlist.add(scoreOOP.NameInputandroid)
        namestudentlist.add(scoreOOP.NameInPutIOS)
        scorestudentlist.add(scoreOOP.ScoreInPutandroid.toString())
        scorestudentlist.add(scoreOOP.ScoreInPutIOS.toString())
    }

    private fun updateDataListView() {
        val listView = AdapterUpdateLV(
            context = this, imgStudentArrayList = imgstudentlist, nameStudentArrayString = namestudentlist,
            scoreStudentArrayString = scorestudentlist
        )
        lvdata.adapter = listView
    }

}

