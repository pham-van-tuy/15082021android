package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_data_input.*


class DataInput : AppCompatActivity() {
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

