package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_data_input.*
import kotlinx.android.synthetic.main.view_sub_bottom.view.*



class DataInput : AppCompatActivity() {
    var studentOOP = studentOOP()
    private var updateMemoriData = ReadAndWriteMemory ()
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        upDateStudentOOP()
        savedInstanceState.putSerializable(DATA_TRANFER, studentOOP)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        studentOOP = savedInstanceState.getSerializable(DATA_TRANFER) as studentOOP
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
        // BTN SET ONCLICK LISTENNER
        viewDataInputAndroid.getIncBtn().setOnClickListener {
            studentOOP.androiScoreINC()
            viewDataInputAndroid.tvScore.text = studentOOP.ScoreInPutandroid.toString()
        }
        viewDataInputAndroid.getDecBtn().setOnClickListener {
            studentOOP.androiScoreDEC()
            viewDataInputAndroid.tvScore.text = studentOOP.ScoreInPutandroid.toString()
        }
        viewDataInputIos.getIncBtn().setOnClickListener {
            studentOOP.IncScoreIOS()
            viewDataInputIos.tvScore.text = studentOOP.ScoreInPutIOS.toString()
        }
        viewDataInputIos.getDecBtn().setOnClickListener {
            studentOOP.decScoreIOS()
            viewDataInputIos.tvScore.text = studentOOP.ScoreInPutIOS.toString()
        }
        btnDone.setOnClickListener {
            upDateStudentOOP()
            if (studentOOP.NameInputandroid.isNotEmpty()&& studentOOP.NameInPutIOS.isNotEmpty()
            ){
                updateMemoriData.writeDataMemory(this,"phamvantuy.txt",
                    studentOOP.NameInputandroid +"\n" + studentOOP.ScoreInPutandroid + "\n"
                            + studentOOP.NameInPutIOS + "\n" + studentOOP.ScoreInPutIOS)
            }else Toast.makeText(this, "data is empty it will not save", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(DATA_TRANFER, studentOOP)
            setResult(RESULT_OK, intent)
            this.finish()
        }
    }

    // Funtion
    fun upDateStudentOOP() {
        studentOOP.NameInputandroid = viewDataInputAndroid.edtName.text.toString()
        studentOOP.NameInPutIOS = viewDataInputIos.edtName.text.toString()
    }

    fun upDateDataInput() {
        viewDataInputAndroid.tvScore.text = studentOOP.ScoreInPutandroid.toString()
        viewDataInputIos.tvScore.text = studentOOP.ScoreInPutIOS.toString()
        viewDataInputAndroid.edtName.setText(studentOOP.NameInputandroid)
        viewDataInputIos.edtName.setText(studentOOP.NameInPutIOS)
    }





}







