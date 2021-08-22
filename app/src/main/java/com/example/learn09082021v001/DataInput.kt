package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import kotlinx.android.synthetic.main.activity_data_input.*



class DataInput : AppCompatActivity() {
//   override fun onSaveInstanceState(savedInstanceState: Bundle) {
//        super.onSaveInstanceState(savedInstanceState)
//        savedInstanceState.putString("androidname", edtNameAndroid.text.toString())
//        savedInstanceState.putString("iosname", edtNameIOS.text.toString())
//        savedInstanceState.putString("androidscore", tvScoreAndroid.text.toString())
//        savedInstanceState.putString("iodscore", tvScoreIOS.text.toString())
//  }
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState);
//        edtNameAndroid.text = savedInstanceState.get("androidname") as Editable
//        tvScoreAndroid.text = savedInstanceState.get("androidscore") as Editable

 //   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_input)
        val scoreOOP = NameScoreOOP()
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
            tvScoreIOS.text = scoreOOP.ScoreInPutIOS.toString() }

            btnDone.setOnClickListener {
                scoreOOP.NameInputandroid = edtNameAndroid.text.toString()
                scoreOOP.NameInPutIOS = edtNameAndroid.text.toString()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("AndroidName", edtNameAndroid.text.toString())
                intent.putExtra("IOSName", edtNameIOS.text.toString())
                intent.putExtra("AndroidScore", tvScoreAndroid.text.toString())
                intent.putExtra("IOSScore", tvScoreIOS.text.toString())
                startActivity(intent)
                Log.d("AAA", "BTN DONE ON")
            }

        }
    }

