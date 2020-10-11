package layout

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Student     (
    @Expose
    @SerializedName("Gender") val Gender: String,

    @Expose
    @SerializedName("Email") val Email: String,

    @Expose
    @SerializedName("std_name") val std_name: String,

    @Expose
    @SerializedName("Salary") val Salary: Int

)