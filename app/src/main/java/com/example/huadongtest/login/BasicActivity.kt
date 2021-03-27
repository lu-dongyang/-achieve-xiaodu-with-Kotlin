package com.example.huadongtest.login



import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.huadongtest.R

import com.example.huadongtest.datatype.ActivityCollector


open class BasicActivity : AppCompatActivity() {
    lateinit var receiver: ForceOfflineReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
        ActivityCollector.addActivity(this)
        Log.d("abc","进入Basic")
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.huadongtest.PORCE_OFFLINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver,intentFilter)

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }
    inner class ForceOfflineReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            AlertDialog.Builder(context).apply {
                setTitle("警告")
                setMessage("你已经被强制下线")
                setCancelable(false)
                setPositiveButton("确定"){_,_->
                    ActivityCollector.finishAll()
                    val i = Intent(context,login_::class.java)
                    context.startActivity(i) }
                show()
            }
        }
    }
}