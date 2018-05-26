package com.hfad.higherorlower

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomNumber = random()
        tv_tries.setText(tries.toString())
    }

    fun onGuess(view : View){
        val inputNumberString = et_number.text.toString()

        if(inputNumberString == "" || inputNumberString == "0"){
            Toast.makeText(this, "Number can't be empty OR 0", Toast.LENGTH_LONG).show()
        }else {
            val inputNumberInt = inputNumberString.toInt()

            if(inputNumberInt > 20){
                Toast.makeText(this, "Number greater than 20 not allowed", Toast.LENGTH_LONG).show()
            }else {
                play(inputNumberInt, randomNumber)
            }
        }
    }

    fun random() : Int {
        return Random().nextInt(20) + 1
    }

    fun play(inputNumber : Int, rndNumber : Int){

        if(inputNumber != rndNumber){
            if(inputNumber > rndNumber){
                tries++
                tv_tries.setText(tries.toString())
                Toast.makeText(this, "Lower", Toast.LENGTH_SHORT).show()
            }else if(inputNumber < rndNumber) {
                tries++
                tv_tries.setText(tries.toString())
                Toast.makeText(this, "Higher", Toast.LENGTH_SHORT).show()
            }
        }else {
            Toast.makeText(this, "You are correct. Tries = ${tries+1} play again!", Toast.LENGTH_LONG).show()
            et_number.text.clear()
            randomNumber = random()
            tries = 0
            tv_tries.setText(tries.toString())
        }
    }

    companion object {
        var randomNumber : Int = 0
        var tries : Int = 0
    }
}
