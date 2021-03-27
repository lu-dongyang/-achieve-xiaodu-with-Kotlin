package com.example.huadongtest.Database



import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class databaseHelper(val context: Context, name:String, verson:Int) : SQLiteOpenHelper(context,name,null,verson) {
    //图片和名称
    private val createjilu = "create table record("+"id integer primary key autoincrement,"+"sentence String)"
    //  private val createCategory = "create table Category("+"id integer primary key autoincrement,"+"category_name text,"+"category_code integer)"


    override fun onCreate(db: SQLiteDatabase) {
        //TODO("Not yet implemented")
        db.execSQL(createjilu)
        //     db.execSQL(createCategory)
        Toast.makeText(context,"Create succeed", Toast.LENGTH_SHORT).show()

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // TODO("Not yet implemented")
        db.execSQL("drop table if exists record")
        //  db.execSQL("drop table if exists Category")
        onCreate(db)

    }

}