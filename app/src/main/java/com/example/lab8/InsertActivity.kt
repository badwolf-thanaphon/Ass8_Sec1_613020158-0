package layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.lab8.R
import kotlinx.android.synthetic.main.activity_insert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
    }
    fun addStudent(v: View){
        val serv: StudentAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentAPI::class.java)

            serv.insertStd(
                checkSeLectGender() as String,
                edt_email.text.toString(),
                edt_name.text.toString(),
                edt_salary.text.toString().toInt()

            ).enqueue(object :Callback<Student>{
                override fun onResponse(call: Call<Student>, response: Response<Student>) {
                    if (response.isSuccessful()){
                        Toast.makeText(applicationContext,
                            "Successfully Inserted",
                            Toast.LENGTH_LONG).show()
                        finish()
                    }else{
                        Toast.makeText(applicationContext,
                            "Failed to Insert",
                            Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Student>, t: Throwable) {
                    Toast.makeText(applicationContext,
                        "Error onFailure"+t.message,
                        Toast.LENGTH_LONG).show()
                }
            })
    }

    private fun checkSeLectGender(): Any {
        val selectID = RadioGroup_Gender.checkedRadioButtonId
        val selectValue = findViewById<RadioButton>(selectID).text
        return selectValue
    }

    fun  rstStudent(v: View){
        edt_email.text.clear()
        edt_name.text.clear()
        edt_salary.text.clear()
        RadioGroup_Gender.clearCheck()
    }
}
