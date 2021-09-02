package com.example.learn09082021v001

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_data_input.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable;


class DataInput : AppCompatActivity() {
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putSerializable(sendData, scoreOOP)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        scoreOOP = savedInstanceState.getSerializable(sendData) as NameScoreOOP
        getdataclassOOP()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_input)
       var scoreOOP = NameScoreOOP( )
        // BTN SET ONCLICK LISTENNER
        btnINCAndroid.setOnClickListener {
            scoreOOP.androiScoreINC()
            tvScoreAndroid.text = scoreOOP.ScoreInPutandroid.toString()
        }
        btnDECAndroid.setOnClickListener {
            scoreOOP.androiScoreDEC()
            tvScoreAndroid.text = scoreOOP.ScoreInPutandroid.toString()
        }
        btnINCIOS.setOnClickListener {
            scoreOOP.IOSScoreINC()
            tvScoreIOS.text = scoreOOP.ScoreInPutIOS.toString()
        }
        btnDECIOS.setOnClickListener {
            scoreOOP.IOSScoreDEC()
            tvScoreIOS.text = scoreOOP.ScoreInPutIOS.toString()
        }

        btnDone.setOnClickListener {
            scoreOOP.NameInputandroid = edtNameAndroid.text.toString()
            scoreOOP.NameInPutIOS = edtNameIOS.text.toString()
            val intent = Intent(this, MainActivity::class.java)
          intent.putExtra(sendData,scoreOOP )
            setResult(RESULT_OK, intent)
            finish();
        }

    }
    fun getdataclassOOP () {
        tvScoreAndroid.text = scoreOOP. ScoreInPutandroid.toString()
        tvScoreIOS.text = scoreOOP.ScoreInPutIOS.toString()
    }
}




