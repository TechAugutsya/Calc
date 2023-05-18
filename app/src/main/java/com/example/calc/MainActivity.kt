package com.example.calc

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var lastNumeric= false
    var lastDot= false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun  onDigit(view: View){
        textview1.append((view as Button).text)
        lastNumeric=true

    }
    fun onClear(view: View){
        textview1.text=""
        lastDot=false
        lastNumeric=false
    }

    fun onEqual(view: View){
        if(lastNumeric){
            var tvValue =textview1.text.toString()
            var prefix=""
            try {
                if(tvValue.startsWith("-")){
                    prefix="-"
                    tvValue =tvValue.substring(1)
                }
                if (tvValue.contains("-")){
                    val splitValue=tvValue.split("-")
                    var one=splitValue[0]
                    var two=splitValue[1]
                    if (!prefix.isEmpty()){
                        one= prefix + one
                    }
                    textview1.text=removeZero((one.toDouble() - two.toDouble()).toString())                }
                else if (tvValue.contains("+")){
                    val splitValue=tvValue.split("+")
                    var one=splitValue[0]
                    var two=splitValue[1]
                    if (!prefix.isEmpty()){
                        one= prefix + one
                    }
                    textview1.text=removeZero((one.toDouble() + two.toDouble()).toString())                }
                else if (tvValue.contains("*")){
                    val splitValue=tvValue.split("*")
                    var one=splitValue[0]
                    var two=splitValue[1]
                    if (!prefix.isEmpty()){
                        one= prefix + one
                    }
                    textview1.text=removeZero((one.toDouble() * two.toDouble()).toString())                }
                else if (tvValue.contains("/")){
                    val splitValue=tvValue.split("/")
                    var one=splitValue[0]
                    var two=splitValue[1]
                    if (!prefix.isEmpty()){
                        one= prefix + one
                    }
                    textview1.text=removeZero((one.toDouble() / two.toDouble()).toString())                }
                else if (tvValue.contains("%")){
                    val splitValue=tvValue.split("%")
                    var one=splitValue[0]
                    var two=splitValue[1]
                    if (!prefix.isEmpty()){
                        one= prefix + one
                    }
                    textview1.text=removeZero((one.toDouble() % two.toDouble()).toString())
                }

            }catch (e:ArithmeticException){
            e.printStackTrace()}
        }
    }
    fun onDecimalPoint(view: View){
        if(lastNumeric && !lastDot){
            textview1.append(".")
            lastNumeric=false
            lastDot=true
        }
    }
    @SuppressLint("SuspiciousIndentation")
    private fun removeZero(result:String):String{
        var value=result
        if (result.contains(".0"))
            value=result.substring(0,result.length-2)
            return  value

    }
    fun  onOperatop(view: View){
        if (lastNumeric && !isOperatorAdded(textview1.text.toString()))
        {
            textview1.append((view as Button).text)
            lastNumeric=false
            lastDot=false
        }
    }

    private  fun isOperatorAdded(value: String):Boolean{
        return if (value.startsWith("-")){
            false
        }else{
            value.contains("/") || value.contains("+") ||
                    value.contains("-") || value.contains("*") || value.contains("%")
        }
    }


    fun removeLastChar(view: View) {
        var str=textview1.getText().toString()
        val k=str.length
        if (k!=0){
        str=str.substring(0,str.length-1)
        textview1.setText(str)}
        lastDot=false
        lastNumeric=false

    }

    }



