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
    var StudentOOP = NameScoreOOP()
    private var updateMemoriData = ReadAndWriteMemori ()
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
            updateMemoriData.WriteDataMemory(this,"phamvantuy.txt",
                StudentOOP.NameInputandroid +"\n" + StudentOOP.ScoreInPutandroid + "\n"
                        + StudentOOP.NameInPutIOS + "\n" + StudentOOP.ScoreInPutIOS)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(DATA_TRANFER, StudentOOP)
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





}







