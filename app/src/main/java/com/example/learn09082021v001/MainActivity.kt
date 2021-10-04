package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.learn09082021v001.fragmentLayout.ActivityFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_sub_bottom.view.*

const val DATA_TRANFER = "datatranfer"


class MainActivity : AppCompatActivity() {
    var StudentOOP = NameScoreOOP()
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putSerializable(DATA_TRANFER, StudentOOP)
        checkDataFull()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        StudentOOP = savedInstanceState.getSerializable(DATA_TRANFER) as NameScoreOOP
        upDateDataMain()
        checkDataFull()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && resultCode == RESULT_OK) {
            StudentOOP = data.getSerializableExtra(DATA_TRANFER) as NameScoreOOP
            upDateDataMain()
            checkDataFull()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a = findViewById<Button>(R.id.btnINC)
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
        btnfragment.setOnClickListener {
            val intent = Intent (this ,ActivityFragment ::class.java)
            startActivity(intent)
        }
    }
    // Funtion
    private fun upDateDataMain() {
        viewMainAndroid.edtName.setText(StudentOOP.NameInputandroid)
        viewMainAndroid.tvScore.text = StudentOOP.ScoreInPutandroid.toString()
        viewMainIos.edtName.setText(StudentOOP.NameInPutIOS)
        viewMainIos.tvScore.text = StudentOOP.ScoreInPutIOS.toString()
    }

    private fun checkDataFull() {
        if (viewMainAndroid.dataNotEmpty() || viewMainIos.dataNotEmpty()) {
            btnStartReset.setText("RESET")
        } else btnStartReset.setText("START")
    }

    private fun clearData() {
        viewMainAndroid.clear()
        viewMainIos.clear()
    }

    }





