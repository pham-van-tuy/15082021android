package com.example.learn09082021v001

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_data_input.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString("nameandroidView", tvViewNameAndroid.text.toString())
        savedInstanceState.putString("scoreandroidView", tvViewScoreAndroid.text.toString())
        savedInstanceState.putString("nameiosView", tvViewNameIOS.text.toString())
        savedInstanceState.putString("scoreiosView", tvViewScoreIOS.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tvViewNameAndroid.text = savedInstanceState.getString("nameandroidView")
        tvViewScoreAndroid.text = savedInstanceState.getString("scoreandroidView")
        tvViewNameIOS.text = savedInstanceState.getString("nameiosView")
        tvViewScoreIOS.text = savedInstanceState.getString("scoreiosView")

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && resultCode == RESULT_OK) {
            tvViewNameAndroid.setText(data.getStringExtra("nameandroidSend"))
            tvViewNameIOS.setText(data.getStringExtra("nameiosSend"))
            tvViewScoreAndroid.setText(data.getStringExtra("scoreandroidSend"))
            tvViewScoreIOS.setText(data.getStringExtra("scoreiosSend"))
            datacheck()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStartReset.setOnClickListener {
            if (tvViewNameAndroid.text.isEmpty() && tvViewNameIOS.text.isEmpty() &&
                    tvViewScoreAndroid.text.isEmpty()  && tvViewScoreIOS.text.isEmpty()) {
                val intent: Intent = Intent(this, DataInput::class.java)
                startActivityForResult(intent, 1)
            } else { dataclear () }
        }


    }
    fun datacheck () {
        if (tvViewNameAndroid.text.isNotEmpty() || tvViewNameIOS.text.isNotEmpty()
            || tvViewScoreAndroid.text.isNotEmpty() || tvViewScoreIOS.text.isNotEmpty()) {
            btnStartReset.setText("RESET") } else btnStartReset.setText("START") }
    fun dataclear (){
        tvViewNameAndroid.setText("")
        tvViewNameIOS.setText("")
        tvViewScoreAndroid.setText("")
        tvViewScoreIOS.setText("")
        btnStartReset.setText("START") }
}