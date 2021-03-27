package com.example.huadongtest.Database

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.huadongtest.R
import kotlinx.android.synthetic.main.activity_database.*
import kotlinx.android.synthetic.main.fragment_second_blank.*

class database : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)


        val dbHelper = databaseHelper(this,"record.db",1)

        val factory = LayoutInflater.from(this)

        val layout: View = factory.inflate(R.layout.fragment_second_blank, null)

        val textview = layout.findViewById<TextView>(R.id.xiaodu_text)



        inputdatabasebutton.setOnClickListener {

//            textView.setText("string").toString()

            val sentence =textview.text.toString()
//            Log.d("data",sentence)
//            val photo = getDrawResourceID(name)
            val db = dbHelper.writableDatabase
            db.execSQL("insert into record(sentence)values(?)" ,arrayOf(sentence))

        }
        deletedatabasebutton.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.execSQL("delete from record")

        }

        seedatabasebutton.setOnClickListener {
            val intent = Intent(this, wenzi::class.java)
            startActivity(intent)
        }
    }

    /**
     * 根据图片的名称获取对应的资源id
     * @param resourceName
     * @return
     */
//    fun getDrawResourceID(resourceName: String?): Int {
//        val res: Resources = resources
//        return res.getIdentifier(resourceName, "drawable", packageName)
//    }
}