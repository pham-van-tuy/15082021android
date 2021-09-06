package com.example.learn09082021v001


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_data_input.*

class DataInput : AppCompatActivity() {
    var scoreOOP = NameScoreOOP()
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putSerializable(DATA_TRANFER, scoreOOP)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        scoreOOP = savedInstanceState.getSerializable(DATA_TRANFER) as NameScoreOOP
        upDateDataInput()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_input)
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
            intent.putExtra(DATA_TRANFER, scoreOOP)
            setResult(RESULT_OK, intent)
            this.finish()
        }

    }

    // Funtion
    fun upDateDataInput() {
        tvScoreAndroid.text = scoreOOP.ScoreInPutandroid.toString()
        tvScoreIOS.text = scoreOOP.ScoreInPutIOS.toString()
    }
}




