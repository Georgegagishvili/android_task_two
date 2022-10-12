package com.example.tasktwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var resText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        init()
        displayResult()
    }

    private fun init(){
        resText = findViewById(R.id.result)
    }

    private fun displayResult(){
        resText.text = intent.getStringExtra("result")
    }
}