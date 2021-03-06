package com.example.simpletipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var billAmount:EditText
    lateinit var tipAmount:EditText
    lateinit var resultAmount:TextView
    lateinit var btnCalc:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billAmount = findViewById(R.id.bill)
        tipAmount = findViewById(R.id.tip)
        resultAmount = findViewById(R.id.result)
        btnCalc = findViewById(R.id.calculate)

        btnCalc.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        if (TextUtils.isEmpty(billAmount.text.toString()))
        {
            billAmount.error = "Can't be empty.."
            return
        }
        if (TextUtils.isEmpty(tipAmount.text.toString()))
        {
            tipAmount.error = "Can't be empty.."
        }
        val doubleAmt = billAmount.text.toString().toDouble()
        val tipAmt  = tipAmount.text.toString().toDouble()

        val calc_tip = (doubleAmt*tipAmt)/100
        resultAmount.text = calc_tip.toString()
    }
}