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
public var nameAndroid = "nameAndroidView"
public var scoreAndroid = "scoreAndroidView"
public var nameIos = "nameIosView"
public var scoreIos = "scoreIosView"

class MainActivity : AppCompatActivity() {
    override fun onSaveInstanceState(savedInstanceState: Bundle) {super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString(nameAndroid, tvViewNameAndroid.text.toString())
        savedInstanceState.putString(scoreAndroid, tvViewScoreAndroid.text.toString())
        savedInstanceState.putString(nameIos, tvViewNameIOS.text.toString())
        savedInstanceState.putString(scoreIos, tvViewScoreIOS.text.toString())
        checkDataFull()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tvViewNameAndroid.text = savedInstanceState.getString(nameAndroid)
        tvViewScoreAndroid.text = savedInstanceState.getString(scoreAndroid)
        tvViewNameIOS.text = savedInstanceState.getString(nameIos)
        tvViewScoreIOS.text = savedInstanceState.getString(scoreIos)
        checkDataFull()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && resultCode == RESULT_OK) {
            tvViewNameAndroid.setText(data.getStringExtra(nameAndroid))
            tvViewScoreAndroid.setText(data.getStringExtra(scoreAndroid))
            tvViewNameIOS.setText(data.getStringExtra(nameIos))
            tvViewScoreIOS.setText(data.getStringExtra(scoreIos))
  //        data.getStringExtra("datasendscreen")
        //    data.ge
            checkDataFull()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var scoreOOP = NameScoreOOP(NameInputandroid = "", ScoreInPutandroid = 0,
           NameInPutIOS = "", ScoreInPutIOS = 0)
        btnStartReset.setOnClickListener {
            if (tvViewNameAndroid.text.isEmpty() && tvViewNameIOS.text.isEmpty() &&
                    tvViewScoreAndroid.text.isEmpty()  && tvViewScoreIOS.text.isEmpty()) {
                val intent: Intent = Intent(this, DataInput::class.java)
                startActivityForResult(intent, 1)
            } else { clearData() }
        }
    }
    fun checkDataFull () {
        if (tvViewNameAndroid.text.isNotEmpty() || tvViewNameIOS.text.isNotEmpty()
            || tvViewScoreAndroid.text.isNotEmpty() || tvViewScoreIOS.text.isNotEmpty()) {
            btnStartReset.setText("RESET") } else btnStartReset.setText("START") }
    fun clearData (){
        tvViewNameAndroid.setText("")
        tvViewNameIOS.setText("")
        tvViewScoreAndroid.setText("")
        tvViewScoreIOS.setText("")
        btnStartReset.setText("START") }
}