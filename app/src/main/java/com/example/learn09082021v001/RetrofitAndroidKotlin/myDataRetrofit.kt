package com.example.learn09082021v001.RetrofitAndroidKotlin

import com.google.gson.annotations.SerializedName

class myDataRetrofit(
    var page: Int?,
    var perPage: Int?,
    var total: Int?,
    var totalPages: Int?,
    var data: List<DataForm>?

)

class DataForm(
    var id: Int,
    var email: String?,
    var first_name: String?,
    var last_name: String?,
    var avatar: String
)

data class dataUpdateRetrofit(
    @SerializedName("name")
    var nameSecurity: String,
    @SerializedName("job")
    var jobSecurity: String
) {
    @SerializedName("id")
    var idSecurity: String? = null

    @SerializedName("createdAt")
    var createdAtSecurity: String? = null
}



