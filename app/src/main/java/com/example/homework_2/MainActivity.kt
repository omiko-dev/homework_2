package com.example.homework_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var etNumber: EditText
    private lateinit var btn: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber = findViewById(R.id.etnResult)
        tvResult = findViewById(R.id.tvResult)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
            getNumberInString(etNumber, tvResult)
        }
    }

    private fun getNumberInString(etNum: EditText, tvRes: TextView){


        val oneToTen = arrayOf("ერთ", "ორ", "სამ", "ოთხ", "ხუთ", "ექვს", "შვიდ", "რვ", "ცხრ", "ათ")
        val tenToTwenty = arrayOf("თერთმეტი", "თორმეტი", "ცამეტი", "თოთხმეტი", "თხუთმეტი", "თექვსმეტი", "ჩვიდმეტი", "თვრამეტი", "ცხრამეტი")
        val platoon = arrayOf("ოც", "ორმოც", "სამოც", "ოთხმოც")
        val hundred = "ას"
        val da = "და"
        val i = "ი"
        val ten = "ათი"

        if(etNumber.text.isNotBlank()) {  // warning

            var userNumber = etNum.text.toString().toInt()
            var result = ""

            if (userNumber < 1 || userNumber > 1000) { // warning


                Toast.makeText(
                    this@MainActivity,
                    "Please Enter Number Between 1-1000",
                    Toast.LENGTH_SHORT
                ).show()


            } else {

//                    200; 300; 400; 500; 600; 700; 800; 900; 1000
                if(userNumber > 99){
                    result += oneToTen[(userNumber / 100)-1]
                    if(userNumber.toString()[0] == '8' || userNumber.toString()[0] == '9'){
                        result += 'ა'
                    }
                    result += hundred
                    if(userNumber % 100 == 0){
                        result += i
                    }
                    tvRes.text = result.toString()
                }

//                    100
                if(userNumber == 100){
                    result += hundred
                    result += i
                    tvRes.text = result.toString()
                }else if(userNumber in 101..199){
                    result += hundred
                }

                //
                userNumber -= (userNumber / 100)*100
                //


//                    21-29; 41-49; 61-69; 81-89;
                if (userNumber in 21..99 && userNumber % 20 in 1..9) {
                    result += platoon[(userNumber / 20) - 1]
                    result += da
                    result += oneToTen[(userNumber % 10) - 1]
                    if(
                        nineAndEightChecker(userNumber)
                    ){
                        result += 'ა'
                    }else{
                        result += i
                    }

                    tvRes.text = result.toString()
                }

//                    51-59; 71-79; 91-99;
                if (userNumber in 21..99 && userNumber % 20 > 10) {
                    result += platoon[(userNumber / 20) - 1]
                    result += da
                    result += tenToTwenty[(userNumber % 10) - 1]
                    tvRes.text = result.toString()
                }

//                    20, 40, 60, 80
                if(userNumber in 20..99 && userNumber % 20 == 0){
                    result += platoon[(userNumber/20)-1]
                    result += i
                    tvRes.text = result.toString()
                }

//                    30, 50, 70, 90
                if(userNumber in 21..99 && userNumber % 20 == 10){
                    result += platoon[(userNumber/20)-1]
                    result += da
                    result += ten
                    tvRes.text = result.toString()
                }

//                    10 - 19
                if(userNumber in 11..19){
                    result += tenToTwenty[userNumber - 11]
                    tvRes.text = result.toString()
                }

//                    1 - 10
                if (userNumber in 1..9) {
                    result += oneToTen[userNumber - 1]

                    if(
                        nineAndEightChecker(userNumber)
                    ){
                        result += 'ა'
                    }else{
                        result += i
                    }

                    tvRes.text = result.toString()
                }

            }
        }
        else
        {
            Toast.makeText(
                this@MainActivity,
                "Please Enter Number Between 1-1000",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
    private fun nineAndEightChecker(num: Int): Boolean{
        return (
                num.toString()[num.toString().length - 1] == '8' ||
                        num.toString()[num.toString().length - 1] == '9'
                )
    }
}



























