package com.example.lab7dialogrv_sec1_603020771_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layou.view.*


class MainActivity : AppCompatActivity() {
    val studentList = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testStudentData()
        recycler_view.adapter = StudentsAdapter(this.studentList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()
    }

    fun addStudent(view: View) {

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layou,null)
        val mBundle = AlertDialog.Builder(this)
        mBundle.setView(mDialogView)
        val mAlertDialog = mBundle.show()

        mDialogView.btnAdd.setOnClickListener{
            studentList.add( Student( mDialogView.edt_id.text.toString(),mDialogView.edt_name.text.toString(),
                mDialogView.edt_age.text.toString().toInt()))
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext,"The student is added successfully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }
    }

    fun testStudentData(){
        studentList.add(Student("603020771-3","Chanathip",20))
        studentList.add(Student("603020368-8","Warissara",20))
    }
}
