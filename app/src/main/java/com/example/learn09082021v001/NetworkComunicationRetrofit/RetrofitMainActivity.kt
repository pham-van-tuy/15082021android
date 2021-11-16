package com.example.learn09082021v001.NetworkComunicationRetrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learn09082021v001.R
import kotlinx.android.synthetic.main.activity_retrofit_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class RetrofitMainActivity : AppCompatActivity() {
    var interfaceAPIRetrofit: InterfaceAPIRetrofit? = null
    var APIClient = APIClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_main)
        btnUpdateScreen.setOnClickListener {
            val intent = Intent(this, UpdateDataToRetrofit::class.java)
            startActivity(intent)
        }
        rcvRetrofit.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        getMyData()
        interfaceAPIRetrofit = APIClient.getClient()?.create(InterfaceAPIRetrofit::class.java)
        val call = interfaceAPIRetrofit?.getDataFromAPI()
        call!!.enqueue(object : Callback<myDataRetrofit?> {
            override fun onResponse(
                call: Call<myDataRetrofit?>,
                response: Response<myDataRetrofit?>
            ) {
                Toast.makeText(this@RetrofitMainActivity, "LOAD COMPLETE", Toast.LENGTH_SHORT)
                    .show()
                val resource = response.body()
                val dataReceive = resource?.data
                val pagerReceive = resource?.page
                val totalReceive = resource?.total
                val totalPagesReceive = resource?.totalPages
                val displayResponse = "$pagerReceive + $totalReceive+ $totalPagesReceive "
                Log.d("TAG", displayResponse)
                val arraydata = ArrayList<DataForm>()
                if (dataReceive != null) {
                    arraydata.addAll(dataReceive.toTypedArray())
                    rcvRetrofit.adapter = AdapterRCVretrofit(
                        myDataRCVView = arraydata
                    )
                }
            }

            override fun onFailure(call: Call<myDataRetrofit?>, t: Throwable) {
                Toast.makeText(this@RetrofitMainActivity, "LOAD API FAIL", Toast.LENGTH_SHORT)
                    .show()
                call.cancel()
            }
        })
    }
}
