package com.example.learn09082021v001


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_data_input.*
import kotlinx.android.synthetic.main.view_sub_bottom.view.*

class DataInput : AppCompatActivity() {
    var scoreOOP = NameScoreOOP()
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        updateScoreOOP()
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
        viewDataInputAndroid.getIncBtn().setOnClickListener {
            scoreOOP.androiScoreINC()
            viewDataInputAndroid.tvScore.text = scoreOOP.ScoreInPutandroid.toString()
        }
        viewDataInputAndroid.getDecBtn().setOnClickListener {
            scoreOOP.androiScoreDEC()
            viewDataInputAndroid.tvScore.text = scoreOOP.ScoreInPutandroid.toString()
        }
        viewDataInputIos.getIncBtn().setOnClickListener {
            scoreOOP.IOSScoreINC()
            viewDataInputIos.tvScore.text = scoreOOP.ScoreInPutIOS.toString()
        }
        viewDataInputIos.getDecBtn().setOnClickListener {
            scoreOOP.IOSScoreDEC()
            viewDataInputIos.tvScore.text = scoreOOP.ScoreInPutIOS.toString()
        }

        btnDone.setOnClickListener {
            updateScoreOOP()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(DATA_TRANFER, scoreOOP)
            setResult(RESULT_OK, intent)
            this.finish()
        }
    }

    // Funtion
    fun updateScoreOOP() {
        scoreOOP.NameInputandroid = viewDataInputAndroid.edtName.text.toString()
        scoreOOP.NameInPutIOS = viewDataInputIos.edtName.text.toString()
    }

    fun upDateDataInput() {
        viewDataInputAndroid.tvScore.text = scoreOOP.ScoreInPutandroid.toString()
        viewDataInputIos.tvScore.text = scoreOOP.ScoreInPutIOS.toString()
        viewDataInputAndroid.edtName.setText(scoreOOP.NameInputandroid)
        viewDataInputIos.edtName.setText(scoreOOP.NameInPutIOS)

    }
}




