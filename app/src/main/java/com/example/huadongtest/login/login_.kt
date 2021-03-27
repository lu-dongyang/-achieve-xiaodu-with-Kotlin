package com.example.huadongtest.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.huadongtest.R
import kotlinx.android.synthetic.main.activity_login_.*

class login_ : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login_)
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_password", false)
        if (isRemember){
            val accountprefes = prefs.getString("account","")
            val passwordprfes = prefs.getString("password","")
            inputaccount.setText(accountprefes)
            inputpassword.setText(passwordprfes)
            rememberpassword.isChecked = true

        }

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener{
            // Toast.makeText(this,"用户名密码为空",Toast.LENGTH_SHORT).show()
            val account = inputaccount.text.toString()
            val password = inputpassword.text.toString()

            if (account == "123" && password == "123"){
                val editor = prefs.edit()
                if (rememberpassword.isChecked){
                    editor.putBoolean("remember_password",true)
                    editor.putString("account",account)
                    editor.putString("password",password)

                }else{
                    editor.clear()
                }
                editor.apply()
                val intent = Intent(this, loginSuccess::class.java)//跳转
                intent.putExtra("account_name",account)

                startActivity(intent)
                finish()


                // Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show()
            }else{
                if(account.isEmpty()){
                    Toast.makeText(this,"用户名为空", Toast.LENGTH_SHORT).show()
                }
                else{
                    AlertDialog.Builder(this).apply {
                        setTitle("警告")
                        setMessage("用户名或密码错误，请重新输入")
                        setCancelable(false)
                        setPositiveButton("确定"){Dialog,which->  }
                        setNegativeButton("取消"){Dialog,which-> }
                        show()
                    }
                }

            }
        }
    }
}