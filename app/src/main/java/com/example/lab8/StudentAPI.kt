package layout

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface StudentAPI {
    @GET("allstd")
    fun retriveStudent(): Call<List<Student>>

    @FormUrlEncoded
    @POST("std")
    fun insertStd(
        @Field("Gender") Gender: String,
        @Field("Email") Email: String,
        @Field("std_name") std_name: String,
        @Field("Salary") Salary: Int
    ):Call<Student>
}