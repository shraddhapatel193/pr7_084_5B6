package com.example.pr7_084_5b6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.core.view.WindowCompat
import com.example.pr7_084_5b6.databinding.ActivityMainBinding
import com.example.pr7_084_5b6.databinding.ActivityMainVideoBinding

class MainActivity_video : AppCompatActivity() {

    private lateinit var binding: ActivityMainVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_video)

        binding = ActivityMainVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initYouTubePlayer()
        binding.btnSwitchV.setOnClickListener{
            Intent(this,MainActivity::class.java).also { startActivity(it) }
        }


    }

    private fun initYouTubePlayer(){
        val youtubeID = "R3SHDFssDwg"
        val webSetting:WebSettings = binding.webview.settings
        webSetting.javaScriptEnabled = true
        webSetting.loadWithOverviewMode = true
        webSetting.useWideViewPort = true

        binding.webview.webViewClient = WebViewClient()
        binding.webview.loadUrl("https://www.youtube.com/embed/$youtubeID")

    }
}