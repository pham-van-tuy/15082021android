package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class DataInput : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_input)
        val ScoreOOP :NameScoreOOP = NameScoreOOP ()
        // FIND VIEW BY ID
        val edtNameAndroid = findViewById<EditText>(R.id.edtNameAndroid)
        val edtNameIOS = findViewById<EditText>(R.id.edtNameIOS)
        val tvScoreAndroid = findViewById<TextView>(R.id.tvScoreAndroid)
        val tvScoreIOS = findViewById<TextView>(R.id.tvScoreIOS)
        val btnINCAndroid = findViewById<Button>(R.id.btnINCAndroid)
        val btnDECAndroid = findViewById<Button>(R.id.btnDECAndroid)
        val btnINCIOS = findViewById<Button>(R.id.btnINCIOS)
        val btnDECIOS = findViewById<Button>(R.id.btnDECIOS)
        val btnDone = findViewById<Button>(R.id.btnDone)
        // BTN SET ONCLICK LISTENNER
        btnINCAndroid.setOnClickListener {
            if ( edtNameAndroid.text.isNotEmpty() && ScoreOOP.ScoreInPutandroid <= 8 )
            {
            ScoreOOP.ScoreInPutandroid = ScoreOOP.ScoreInPutandroid + 1
            tvScoreAndroid.setText(ScoreOOP.ScoreInPutandroid.toString())
            }
            else Toast.makeText(this, "DATA CHANGE FAIL", Toast.LENGTH_SHORT).show()
        }
        btnDECAndroid.setOnClickListener {
            if ( edtNameAndroid.text.isNotEmpty() && ScoreOOP.ScoreInPutandroid >= 1 )
            {
                ScoreOOP.ScoreInPutandroid = ScoreOOP.ScoreInPutandroid - 1
                tvScoreAndroid.setText(ScoreOOP.ScoreInPutandroid.toString())
            }
            else Toast.makeText(this, "DATA CHANGE FAIL", Toast.LENGTH_SHORT).show()

        }
        btnINCIOS.setOnClickListener {
            if ( edtNameIOS.text.isNotEmpty() && ScoreOOP.ScoreInPutIOS <= 8 )
            {
                ScoreOOP.ScoreInPutIOS = ScoreOOP.ScoreInPutIOS + 1
                tvScoreIOS.setText(ScoreOOP.ScoreInPutIOS.toString())
            }
            else Toast.makeText(this, "DATA CHANGE FAIL", Toast.LENGTH_SHORT).show()

        }
        btnDECIOS.setOnClickListener {
            if ( edtNameIOS.text.isNotEmpty() && ScoreOOP.ScoreInPutIOS >= 1 )
            {
                ScoreOOP.ScoreInPutIOS = ScoreOOP.ScoreInPutIOS - 1
                tvScoreIOS.setText(ScoreOOP.ScoreInPutIOS.toString())
            }
            else Toast.makeText(this, "DATA CHANGE FAIL", Toast.LENGTH_SHORT).show() }

        btnDone.setOnClickListener {

            var intent: Intent = Intent (this ,MainActivity::class.java)
            intent.putExtra("AndroidName", edtNameAndroid.text.toString())
            intent.putExtra("IOSName", edtNameIOS.text.toString())
            intent.putExtra("AndroidScore", tvScoreAndroid.text.toString())
            intent.putExtra("IOSScore", tvScoreIOS.text.toString())
            startActivity(intent)
            Log.d("AAA" , "BTN DONE ON")
            Toast.makeText(this, "btn done on", Toast.LENGTH_SHORT).show()

        }
    }
}