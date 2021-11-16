package com.example.learn09082021v001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learn09082021v001.NetworkComunicationRetrofit.RetrofitMainActivity
import com.example.learn09082021v001.ViewPager.ActivityPager
import com.example.learn09082021v001.ViewPager.ActivityViewPager2Fragment
import com.example.learn09082021v001.fragmentLayout.ActivityFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_sub_bottom.view.*

const val DATA_TRANFER = "datatranfer"

class MainActivity : AppCompatActivity() {
    var studentOOP = studentOOP()
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putSerializable(DATA_TRANFER, studentOOP)
        checkDataFull()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        studentOOP = savedInstanceState.getSerializable(DATA_TRANFER) as studentOOP
        upDateDataMain()
        checkDataFull()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && resultCode == RESULT_OK) {
            studentOOP = data.getSerializableExtra(DATA_TRANFER) as studentOOP
            upDateDataMain()
            checkDataFull()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // view config
        viewMainAndroid.goneButtonAction()
        viewMainIos.goneButtonAction()
        btnStartReset.setOnClickListener {
            if (viewMainAndroid.dataEmpty() && viewMainIos.dataEmpty()) {
                val intent = Intent(this, DataInput::class.java)
                startActivityForResult(intent, 1)
            } else clearData()
            checkDataFull()
        }
        btnfragment.setOnClickListener {
            val intent = Intent (this ,ActivityFragment ::class.java)
            startActivity(intent)
        }
        btnViewPager2.setOnClickListener {
            val intent = Intent (this , ActivityViewPager2Fragment ::class.java)
            startActivity(intent)
        }
        btnViewPager.setOnClickListener {
            val intent = Intent (this , ActivityPager ::class.java)
            startActivity(intent)
        }
        btnRetrofit.setOnClickListener {
            val intent = Intent (this , RetrofitMainActivity ::class.java)
            startActivity(intent)
        }
    }
    // Funtion
    private fun upDateDataMain() {
        viewMainAndroid.edtName.setText(studentOOP.NameInputandroid)
        viewMainAndroid.tvScore.text = studentOOP.ScoreInPutandroid.toString()
        viewMainIos.edtName.setText(studentOOP.NameInPutIOS)
        viewMainIos.tvScore.text = studentOOP.ScoreInPutIOS.toString()
    }

    private fun checkDataFull() {
        if (viewMainAndroid.dataNotEmpty() || viewMainIos.dataNotEmpty()) {
            btnStartReset.setText("RESET")
        } else btnStartReset.setText("START")
    }

    private fun clearData() {
        viewMainAndroid.clear()
        viewMainIos.clear()
    }
    }
