package com.example.learn09082021v001.RetrofitAndroidKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learn09082021v001.R
import kotlinx.android.synthetic.main.activity_update_data_to_retrofit.*
import retrofit2.Call
import retrofit2.Response

class UpdateDataToRetrofit : AppCompatActivity() {
    var interfaceAPIRetrofit: InterfaceAPIRetrofit? = null
    var APIClient = APIClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data_to_retrofit)
        btnDataUpdate.setOnClickListener {
            val user = dataUpdateRetrofit("pham van tuy", "leader")
            interfaceAPIRetrofit = APIClient.getClient()?.create(InterfaceAPIRetrofit::class.java)
            val call1 = interfaceAPIRetrofit?.upDateToRetrofit(user)
            call1!!.enqueue(object : retrofit2.Callback<dataUpdateRetrofit?> {
                override fun onResponse(
                    call1: Call<dataUpdateRetrofit?>?,
                    response: Response<dataUpdateRetrofit?>
                ) {
                    val user1: dataUpdateRetrofit? = response.body()
                    println(user1)
                }

                override fun onFailure(call1: Call<dataUpdateRetrofit?>, t: Throwable?) {
                    call1.cancel()
                }
            })
        }
    }

}
