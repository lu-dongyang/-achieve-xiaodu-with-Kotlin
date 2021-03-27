package com.example.huadongtest.Database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.huadongtest.R
import kotlinx.android.synthetic.main.activity_wenzi.*

class wenzi : AppCompatActivity() {
    private val goodlist = ArrayList<String>()
    val dbHelper = databaseHelper(this,"record.db",1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wenzi)
        initGoods()
        val layoutManager = LinearLayoutManager(this)
        wenzirecycleview.layoutManager = layoutManager

        val adapter = GoodAdapter(goodlist)
        wenzirecycleview.adapter = adapter

    }
    private fun initGoods(){
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("select * from record   ", null)
        if (cursor.moveToFirst())
            do{
                val hanzi = cursor.getString(cursor.getColumnIndex("sentence"))

//                val photo= cursor.getInt(cursor.getColumnIndex("photo"))
                goodlist.add(hanzi)

            }while (cursor.moveToNext())

    }
}