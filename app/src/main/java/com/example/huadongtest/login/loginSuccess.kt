package com.example.huadongtest.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.huadongtest.Database.database
import com.example.huadongtest.Database.databaseHelper
import com.example.huadongtest.R
import kotlinx.android.synthetic.main.activity_login_success.*

class loginSuccess : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_success)
        val extraDate = intent.getStringExtra("account_name")
        // print(extraDate)
        val Account: TextView = findViewById(R.id.loginsuccess)
//        val dbHelper = databaseHelper(this,"yonghu.db",1)


        Account.setText("恭喜"+"$extraDate"+"登陆成功")
        Log.d("LoginSuccess","$extraDate")

//        val goodsview : ImageView = findViewById(R.id.goodsview)
//        val cemeraview : ImageView = findViewById(R.id.cameraview)


        // 左图片
//        goodsview.setOnClickListener{
//            dbHelper.writableDatabase
//
//            val intent = Intent(this, database::class.java)
//
//            startActivity(intent)
//            //创建数据库
//
//        }




//        cemeraview.setOnClickListener{
//            val intent = Intent(this, camera::class.java)
//            startActivity(intent)
//        }

        ButtonforceOffline.setOnClickListener{

            val intent = Intent("com.example.huadongtest.PORCE_OFFLINE")
//            startActivity(intent)
            sendBroadcast(intent)
            Log.d("abc","点击")
        }

    }
}