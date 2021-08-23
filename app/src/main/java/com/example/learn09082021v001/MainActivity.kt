package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // DATA GETEXTRA
        val intent = getIntent()
        tvViewNameAndroid.setText(intent.getStringExtra("AndroidName"))
        tvViewNameIOS.setText(intent.getStringExtra("IOSName"))
        tvViewScoreAndroid.setText(intent.getStringExtra("AndroidScore"))
        tvViewScoreIOS.setText(intent.getStringExtra("IOSScore"))
        if (tvViewNameAndroid.text.isNotEmpty() && tvViewNameIOS.text.isNotEmpty()) {
            btnStartReset.setText("RESET")
        } else {
            btnStartReset.setText("START")
        }
        btnStartReset.setOnClickListener {
            if (tvViewNameAndroid.text.isEmpty() && tvViewNameIOS.text.isEmpty()) {
                val intent: Intent = Intent(this, DataInput::class.java)
                startActivity(intent)
            } else {

                tvViewNameAndroid.setText("")
                tvViewNameIOS.setText("")
                tvViewScoreAndroid.setText("")
                tvViewScoreIOS.setText("")
                btnStartReset.setText("START")
            }
        }

    }
}