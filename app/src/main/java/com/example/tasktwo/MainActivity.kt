package com.example.tasktwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var numberOne: EditText
    private lateinit var numberTwo: EditText
    private lateinit var addBtn: Button
    private lateinit var subBtn: Button
    private lateinit var multBtn: Button
    private lateinit var divBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVariables()
        initListeners()
    }

    private fun initVariables() {
        numberOne = findViewById(R.id.number_one)
        numberTwo = findViewById(R.id.number_two)
        addBtn = findViewById(R.id.add_btn)
        subBtn = findViewById(R.id.subtract_btn)
        divBtn = findViewById(R.id.divide_btn)
        multBtn = findViewById(R.id.multiply_btn)
    }

    private fun initListeners() {
        addBtn.setOnClickListener {
            makeOperation("add")
        }
        subBtn.setOnClickListener {
            makeOperation("sub")
        }
        divBtn.setOnClickListener {
            makeOperation("div")
        }
        multBtn.setOnClickListener {
            makeOperation("mul")
        }
    }

    private fun navigateToResults(result: Double) {
        val intent = Intent(this, ResultActivity::class.java);
        intent.putExtra("result", result.toString())
        startActivity(intent)
    }

    private fun makeOperation(type: String) {
        if (numberOne.text.isNotBlank() && numberTwo.text.isNotBlank()) {
            var res = 0.0
            val textOneRes = numberOne.text.toString().toDouble()
            val textTwoRes = numberTwo.text.toString().toDouble()
            when (type) {
                "add" -> res = textOneRes + textTwoRes
                "sub" -> res = textOneRes - textTwoRes
                "mul" -> res = textOneRes * textTwoRes
                "div" -> res = textOneRes / textTwoRes
            }
            navigateToResults(res)
        }
    }


}