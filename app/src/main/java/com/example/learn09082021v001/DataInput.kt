package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_data_input.*


class DataInput : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_input)
        val ScoreOOP = NameScoreOOP()
        // BTN SET ONCLICK LISTENNER
        btnINCAndroid.setOnClickListener {
            if (edtNameAndroid.text.isNotEmpty() && ScoreOOP.ScoreInPutandroid <= 8) {
                ScoreOOP.ScoreInPutandroid = ScoreOOP.ScoreInPutandroid + 1
                tvScoreAndroid.text = ScoreOOP.ScoreInPutandroid.toString()
            } else Toast.makeText(this, "DATA CHANGE FAIL", Toast.LENGTH_SHORT).show()
        }
        btnDECAndroid.setOnClickListener {
            if (edtNameAndroid.text.isNotEmpty() && ScoreOOP.ScoreInPutandroid >= 1) {
                ScoreOOP.ScoreInPutandroid = ScoreOOP.ScoreInPutandroid - 1
                ScoreOOP.ScoreInPutandroid.toString().also { tvScoreAndroid.text = it }
            } else Toast.makeText(this, "DATA CHANGE FAIL", Toast.LENGTH_SHORT).show()

        }
        btnINCIOS.setOnClickListener {
            if (edtNameIOS.text.isNotEmpty() && ScoreOOP.ScoreInPutIOS <= 8) {
                ScoreOOP.ScoreInPutIOS = ScoreOOP.ScoreInPutIOS + 1
                tvScoreIOS.text = ScoreOOP.ScoreInPutIOS.toString()
            } else Toast.makeText(this, "DATA CHANGE FAIL", Toast.LENGTH_SHORT).show()

        }
        btnDECIOS.setOnClickListener {
            if (edtNameIOS.text.isNotEmpty() && ScoreOOP.ScoreInPutIOS >= 1) {
                ScoreOOP.ScoreInPutIOS = ScoreOOP.ScoreInPutIOS - 1
                tvScoreIOS.text = ScoreOOP.ScoreInPutIOS.toString()

            } else Toast.makeText(this, "DATA CHANGE FAIL", Toast.LENGTH_SHORT).show()
        }
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