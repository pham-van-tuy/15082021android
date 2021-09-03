package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.R.string


const val DATA_TRANFER = "datatranfer"


class MainActivity : AppCompatActivity() {
    var scoreOOP = NameScoreOOP()
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
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStartReset.setOnClickListener {
            if (tvViewNameAndroid.text.isEmpty() && tvViewNameIOS.text.isEmpty() &&
                tvViewScoreAndroid.text.isEmpty() && tvViewScoreIOS.text.isEmpty()
            ) {
                val intent = Intent(this, DataInput::class.java)
                startActivityForResult(intent, 1)
            } else {
                clearData()
            }
        }
    }
    // Funtion

    private fun checkDataFull() {
        if (tvViewNameAndroid.text.isNotEmpty() || tvViewNameIOS.text.isNotEmpty()
            || tvViewScoreAndroid.text.isNotEmpty() || tvViewScoreIOS.text.isNotEmpty()
        ) {
            btnStartReset.setText("RESET")
        } else btnStartReset.setText("START")
    }

    private fun clearData() {
        tvViewNameAndroid.setText("")
        tvViewNameIOS.setText("")
        tvViewScoreAndroid.setText("")
        tvViewScoreIOS.setText("")
        btnStartReset.setText("START")
    }

    private fun upDateDataMain() {
        tvViewNameAndroid.text = scoreOOP.NameInputandroid
        tvViewScoreAndroid.text = scoreOOP.ScoreInPutandroid.toString()
        tvViewNameIOS.text = scoreOOP.NameInPutIOS
        tvViewScoreIOS.text = scoreOOP.ScoreInPutIOS.toString()
    }
}