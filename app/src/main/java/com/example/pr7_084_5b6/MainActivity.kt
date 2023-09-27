package com.example.pr7_084_5b6

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.pr7_084_5b6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoplayer()
        binding.btnswitch.setOnClickListener{
            Intent(this,MainActivity_video::class.java).also { startActivity(it) }
        }

    }
    private fun initVideoplayer() {
        val mediaController = MediaController(this)
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.thestoryoflight)
        binding.myvideoview.setMediaController(mediaController)
        mediaController.setAnchorView(binding.myvideoview)
        binding.myvideoview.setVideoURI(uri)
        binding.myvideoview.requestFocus()
        binding.myvideoview.start()

    }
}