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


class DataInput : AppCompatActivity() {
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString(nameAndroid, edtNameAndroid.text.toString())
        savedInstanceState.putString(scoreAndroid, tvScoreAndroid.text.toString())
        savedInstanceState.putString(nameIos, edtNameIOS.text.toString())
        savedInstanceState.putString(scoreIos, tvScoreIOS.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tvScoreAndroid.text = savedInstanceState.getString(scoreAndroid)
        tvScoreIOS.text = savedInstanceState.getString(scoreIos)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_input)
       var scoreOOP = NameScoreOOP(
            NameInputandroid = "",
            ScoreInPutandroid = 0,
            NameInPutIOS = "",
            ScoreInPutIOS = 0
        )
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
            scoreOOP.NameInPutIOS = edtNameAndroid.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(nameAndroid, edtNameAndroid.text.toString())
            intent.putExtra(scoreAndroid, tvScoreAndroid.text.toString())
            intent.putExtra(nameIos, edtNameIOS.text.toString())
            intent.putExtra(scoreIos, tvScoreIOS.text.toString())
       //     intent.putExtra("dataInputPutsring",scoreOOP)
         //   var a = datasaveandload ()
          //  intent.putExtra("dataInputPutsring",scoreOOP)
            setResult(Activity.RESULT_OK, intent)
            finish();
            Log.d("AAA", "BTN DONE ON")
        }

    }
}




