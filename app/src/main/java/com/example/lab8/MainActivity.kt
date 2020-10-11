package com.example.lab8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_insert.*
import kotlinx.android.synthetic.main.activity_main.*
import layout.InsertActivity
import layout.Student
import layout.StudentAPI
import layout.StudentsAdapter
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var studentList = arrayListOf<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = StudentsAdapter(this.studentList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)


        val btn = findViewById<Button>(R.id.add_emp)
        btn.setOnClickListener {
            gotoAddEmp()
        }

    }
//    private fun checkSeLectGender(): CharSequence? {
//        val selectID = RadioGroup_Gender.checkedRadioButtonId
//        val selectValue = findViewById<RadioButton>(selectID).text
//        return selectValue
//    }
    private fun gotoAddEmp(){
        val intent = Intent(this, InsertActivity::class.java)
               startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//        when(id){
//            R.id.item1 ->{
//                val intent = Intent(this, InsertActivity::class.java)
//                startActivity(intent)
//                return true
//            }
//            else ->  return super.onOptionsItemSelected(item)
//
//        }
//    }

    override fun onResume() {
        super.onResume()
        callStudentdata()
    }
        fun callStudentdata(){
            studentList.clear()
            val serv: StudentAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StudentAPI::class.java)

                    serv.retriveStudent()
                        .enqueue(object : Callback<List<Student>>{
                            override fun onResponse(
                                call: Call<List<Student>>,
                                response: Response<List<Student>>
                            ) {
                                response.body()?.forEach{
                                        studentList.add(Student(it.Gender,it.Email,it.std_name,it.Salary))
                                }
                                recycler_view.adapter =StudentsAdapter(studentList,applicationContext)
                                text1.text = "Employee Information"
                            }

                            override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                                return t.printStackTrace()
                            }
                        })

        }
    fun autocolor(): String {
        val colorX:String =  "#f11111"
        return colorX
    }
}

