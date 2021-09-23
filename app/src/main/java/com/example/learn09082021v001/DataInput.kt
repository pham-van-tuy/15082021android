package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_data_input.*
import kotlinx.android.synthetic.main.view_sub_bottom.view.*

private val imgstudentlist = arrayListOf<Int>()
private val namestudentlist = arrayListOf<String>()
private val scorestudentlist = arrayListOf<String>()

class DataInput : AppCompatActivity(), AdapterUpdateRcv.OnclickRecycleView {
    var StudentOOP = NameScoreOOP()
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        updateScoreOOP()
        savedInstanceState.putSerializable(DATA_TRANFER, StudentOOP)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        StudentOOP = savedInstanceState.getSerializable(DATA_TRANFER) as NameScoreOOP
        upDateDataInput()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.exanble_manu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> Toast.makeText(this, "item 1 onclick", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_input)
        updateDataRecycleView()
        // BTN SET ONCLICK LISTENNER
        viewDataInputAndroid.getIncBtn().setOnClickListener {
            StudentOOP.androiScoreINC()
            viewDataInputAndroid.tvScore.text = StudentOOP.ScoreInPutandroid.toString()
        }
        viewDataInputAndroid.getDecBtn().setOnClickListener {
            StudentOOP.androiScoreDEC()
            viewDataInputAndroid.tvScore.text = StudentOOP.ScoreInPutandroid.toString()
        }
        viewDataInputIos.getIncBtn().setOnClickListener {
            StudentOOP.IOSScoreINC()
            viewDataInputIos.tvScore.text = StudentOOP.ScoreInPutIOS.toString()
        }
        viewDataInputIos.getDecBtn().setOnClickListener {
            StudentOOP.IOSScoreDEC()
            viewDataInputIos.tvScore.text = StudentOOP.ScoreInPutIOS.toString()
        }
        btnDone.setOnClickListener {
            updateScoreOOP()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(DATA_TRANFER, StudentOOP)
            updaterecycleView()
            updateDataRecycleView()
            setResult(RESULT_OK, intent)
            this.finish()
        }
    }

    // Funtion
    fun updateScoreOOP() {
        StudentOOP.NameInputandroid = viewDataInputAndroid.edtName.text.toString()
        StudentOOP.NameInPutIOS = viewDataInputIos.edtName.text.toString()
    }

    fun upDateDataInput() {
        viewDataInputAndroid.tvScore.text = StudentOOP.ScoreInPutandroid.toString()
        viewDataInputIos.tvScore.text = StudentOOP.ScoreInPutIOS.toString()
        viewDataInputAndroid.edtName.setText(StudentOOP.NameInputandroid)
        viewDataInputIos.edtName.setText(StudentOOP.NameInPutIOS)
    }

    private fun updaterecycleView() {
        imgstudentlist.add(R.drawable.androiicon)
        imgstudentlist.add(R.drawable.iosicon)
        namestudentlist.add(StudentOOP.NameInputandroid)
        namestudentlist.add(StudentOOP.NameInPutIOS)
        scorestudentlist.add(StudentOOP.ScoreInPutandroid.toString())
        scorestudentlist.add(StudentOOP.ScoreInPutIOS.toString())
    }

    private fun updateDataRecycleView() {
        rcvlistdata.layoutManager = LinearLayoutManager(this)
        rcvlistdata.setHasFixedSize(true)
        rcvlistdata.adapter = AdapterUpdateRcv(
            imgArrayArrayList = imgstudentlist,
            nameArrayString = namestudentlist, scoreArrayString = scorestudentlist, onclickRCV = this
        )
    }

    override fun onClickImgRCV(imgArray: ArrayList<Int>, position: Int) {
        Toast.makeText(this, "img on " + position, Toast.LENGTH_SHORT).show()
    }

    override fun onClickNameRCV(nameArray: ArrayList<String>, position: Int) {
        Toast.makeText(this, "name on " + position, Toast.LENGTH_SHORT).show()

        when (position) {
            1 -> Toast.makeText(this, "position = 1", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, "position = 2", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onClickScoreRCV(scoreArray: ArrayList<String>, position: Int) {
        Toast.makeText(this, "score on " + position, Toast.LENGTH_SHORT).show()
    }

    override fun onClickOptionRCV(position: Int) {
        Toast.makeText(this, "OPTION ON  " + position, Toast.LENGTH_SHORT).show()
    }
}







