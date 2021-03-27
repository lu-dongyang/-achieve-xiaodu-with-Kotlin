package com.example.huadongtest.download

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.huadongtest.R
import kotlinx.android.synthetic.main.activity_download_service.*

class downloadService : AppCompatActivity() {
    lateinit var downloadBinder: MyService.DownloadBinder

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
//            TODO("Not yet implemented")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_service)

        startServiceBtn.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            startService(intent)
        }

        stopServiceBtn.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            stopService(intent)
        }

        bindServiceBtn.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            bindService(intent,connection, Context.BIND_AUTO_CREATE)
        }

        unbindServiceBtn.setOnClickListener {
            unbindService(connection)
        }
    }



}