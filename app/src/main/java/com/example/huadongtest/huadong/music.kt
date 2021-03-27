package com.example.huadongtest.huadong

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.huadongtest.R
import kotlinx.android.synthetic.main.activity_music.*

class music : AppCompatActivity() {
    private val mediaPlayer = MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        initMediaPlayer()

        play.setOnClickListener {
            if (!mediaPlayer.isPlaying){
                mediaPlayer.start()
            }

        }

        pause.setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.pause()
            }
        }

        stop.setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.reset()
                mediaPlayer.stop()

            }
        }
    }


    private fun initMediaPlayer(){
        val assetManager = assets
        val fd = assetManager.openFd("我一定会爱上你.mp3")
        mediaPlayer.setDataSource(fd.fileDescriptor,fd.startOffset,fd.length)
        mediaPlayer.prepare()

    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}