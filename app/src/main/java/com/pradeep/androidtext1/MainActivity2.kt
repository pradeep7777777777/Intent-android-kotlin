package com.pradeep.androidtext1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val image = findViewById<ImageView>(R.id.image)
        val age = findViewById<TextView>(R.id.age)
        val name = findViewById<TextView>(R.id.name)

        val getname  = intent.extras?.getString("name")
        name.text = getname

        val getage = intent.extras?.getString("age")
        age.text = getage

        val getimage = intent.extras?.getInt("image")
        if (getimage != null) {
            image.setImageResource(getimage)
        }

    }
}