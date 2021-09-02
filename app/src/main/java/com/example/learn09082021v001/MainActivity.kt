package com.example.learn09082021v001

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_data_input.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable;

public val sendData = "datatranfer"
public var scoreOOP = NameScoreOOP()

class MainActivity : AppCompatActivity() {
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putSerializable(sendData, scoreOOP)
        checkDataFull()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        scoreOOP = savedInstanceState.getSerializable(sendData) as NameScoreOOP
        getdataclassOOP()
        checkDataFull()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && resultCode == RESULT_OK) {
            scoreOOP = data.getSerializableExtra(sendData) as NameScoreOOP
            getdataclassOOP()
            checkDataFull()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStartReset.setOnClickListener {
            if (tvViewNameAndroid.text.isEmpty() && tvViewNameIOS.text.isEmpty() &&
                tvViewScoreAndroid.text.isEmpty() && tvViewScoreIOS.text.isEmpty()
            ) {
                val intent: Intent = Intent(this, DataInput::class.java)
                startActivityForResult(intent, 1)
            } else {
                clearData()
            }
        }
    }

    fun checkDataFull() {
        if (tvViewNameAndroid.text.isNotEmpty() || tvViewNameIOS.text.isNotEmpty()
            || tvViewScoreAndroid.text.isNotEmpty() || tvViewScoreIOS.text.isNotEmpty()
        ) {
            btnStartReset.setText("RESET")
        } else btnStartReset.setText("START")
    }

    fun clearData() {
        tvViewNameAndroid.setText("")
        tvViewNameIOS.setText("")
        tvViewScoreAndroid.setText("")
        tvViewScoreIOS.setText("")
        btnStartReset.setText("START")
    }

    fun getdataclassOOP() {
        tvViewNameAndroid.text = scoreOOP.NameInputandroid
        tvViewScoreAndroid.text = scoreOOP.ScoreInPutandroid.toString()
        tvViewNameIOS.text = scoreOOP.NameInPutIOS
        tvViewScoreIOS.text = scoreOOP.ScoreInPutIOS.toString()
    }
}