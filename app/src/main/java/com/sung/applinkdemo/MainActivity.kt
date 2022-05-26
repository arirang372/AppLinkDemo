package com.sung.applinkdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            var intent = Intent(this@MainActivity, MyWebViewActivity::class.java)
            intent.data = Uri.parse("https://walmart.com/search?q=lays%20chips")
            startActivity(intent)
        }
    }
}