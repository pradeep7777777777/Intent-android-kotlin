package com.pradeep.androidtext1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import java.util.ArrayList

class MainActivity : AppCompatActivity(),UserClickLisener {
    lateinit var array: ArrayList<UserModel>
    lateinit var adapter: UserListAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         array = arrayListOf(
            UserModel("Pradeep kumar",18,R.drawable.pradeep1),
            UserModel("Rahul kumar",19,R.drawable.rahul),
            UserModel("Saif Ali",17,R.drawable.saif),
            UserModel("Raj kumar",26,R.drawable.rajkumar),
            UserModel("Pradeep kumar",18,R.drawable.pradeep)
        )

        val userList = findViewById<ListView>(R.id.list_item)
        adapter = UserListAdapter(this,array,this)

        userList.adapter=adapter

        val name = findViewById<EditText>(R.id.name)
        val age = findViewById<EditText>(R.id.age)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            array.add(UserModel(name.text.toString(),age.text.toString().toInt(),R.drawable.pra))
            adapter.notifyDataSetChanged()
        }

    }

    override fun onProfileClick(name: String, p0: Int) {
        array.removeAt(p0)
        adapter.notifyDataSetChanged()
    }

}