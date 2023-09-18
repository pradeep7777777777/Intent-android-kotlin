package com.pradeep.androidtext1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class UserListAdapter(val context: Context, val userArray: ArrayList<UserModel>,val userClick:UserClickLisener): BaseAdapter(){
    override fun getCount(): Int {
        return userArray.size
    }

    override fun getItem(position: Int): Any {
        val p0 = 0
        return userArray[p0]
    }

    override fun getItemId(position: Int): Long {


        return position.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layout = LayoutInflater.from(context).inflate(R.layout.user_list,p2,false)

        val nameText = layout.findViewById<TextView>(R.id.name)
        val ageText = layout.findViewById<TextView>(R.id.age)
        val image = layout.findViewById<ImageView>(R.id.image)

        nameText.text = userArray[p0].name
        ageText.text = userArray[p0].age.toShort().toString()
        image.setImageResource(userArray[p0].image)

        val delit = layout.findViewById<Button>(R.id.delete)
        delit.setOnClickListener {
            userClick.onProfileClick(userArray[p0].name, p0)

        }

        image.setOnClickListener {
            var intent = Intent(context,MainActivity2::class.java)
            intent.putExtra("name",userArray[p0].name)
            intent.putExtra("age",userArray[p0].age.toShort().toString())
            intent.putExtra("image",userArray[p0].image)
            context.startActivity(intent)
        }
        return layout
    }
}
