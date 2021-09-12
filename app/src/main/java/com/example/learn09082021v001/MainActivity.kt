package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_sub_bottom.view.*


const val DATA_TRANFER = "datatranfer"


class MainActivity : AppCompatActivity() {
    var scoreOOP = NameScoreOOP()


    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putSerializable(DATA_TRANFER, scoreOOP)
        checkDataFull()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        scoreOOP = savedInstanceState.getSerializable(DATA_TRANFER) as NameScoreOOP
        upDateDataMain()
        checkDataFull()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && resultCode == RESULT_OK) {
            scoreOOP = data.getSerializableExtra(DATA_TRANFER) as NameScoreOOP
            upDateDataMain()
            checkDataFull()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // view config
        viewMainAndroid.edtName.isEnabled = false
        viewMainIos.edtName.isEnabled = false
        viewMainAndroid.btnDEC.visibility = View.GONE
        viewMainAndroid.btnINC.visibility = View.GONE
        viewMainIos.btnDEC.visibility = View.GONE
        viewMainIos.btnINC.visibility = View.GONE
        btnStartReset.setOnClickListener {
            if (viewMainAndroid.edtName.text.isEmpty() && viewMainAndroid.tvScore.text.isEmpty() &&
                viewMainIos.edtName.text.isEmpty() && viewMainIos.tvScore.text.isEmpty()
            ) {
                val intent = Intent(this, DataInput::class.java)
                startActivityForResult(intent, 1)
            } else clearData()
        }
    }

    private fun upDateDataMain() {
        viewMainAndroid.edtName.setText(scoreOOP.NameInputandroid)
        viewMainAndroid.tvScore.text = scoreOOP.ScoreInPutandroid.toString()
        viewMainIos.edtName.setText(scoreOOP.NameInPutIOS)
        viewMainIos.tvScore.text = scoreOOP.ScoreInPutIOS.toString()
    }
// Funtion

    private fun checkDataFull() {
        if (viewMainAndroid.edtName.text.isNotEmpty() || viewMainIos.edtName.text.isNotEmpty()
            || viewMainAndroid.tvScore.text.isNotEmpty() || viewMainIos.tvScore.text.isNotEmpty()
        ) {
            btnStartReset.setText("RESET")
        } else btnStartReset.setText("START")
    }

    private fun clearData() {
        viewMainAndroid.edtName.setText("")
        viewMainAndroid.tvScore.setText("")
        viewMainIos.edtName.setText("")
        viewMainIos.tvScore.setText("")
        btnStartReset.setText("START")
    }


}

