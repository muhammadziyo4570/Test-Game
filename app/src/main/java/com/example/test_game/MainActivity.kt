package com.example.test_game

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.random
import java.util.*

class MainActivity : AppCompatActivity() {

    var javob = 0

    var random1 = 0
    var random2 = 0
    var random3 = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random()

        btn_next.setOnClickListener {
            if (rad_a.isChecked) {
                if (rad_a.text.toString().toInt() == javob) Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
            }
            if (rad_b.isChecked) {
                if (rad_b.text.toString().toInt() == javob) Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
            }
            if (rad_c.isChecked) {
                if (rad_c.text.toString().toInt() == javob) Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
            }
            if (rad_d.isChecked) {
                if (rad_d.text.toString().toInt() == javob) Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
            }

            rad_group.clearCheck()
            random()
        }
    }

    private fun random() {
        var number1 = Random().nextInt(20)
        var number2 = Random().nextInt(20)
        var amal = Random().nextInt(4)

        when (amal) {
            0 -> {
                txt_misol.text = "$number1 + $number2 = "
                javob = number1 + number2
            }
            1 -> {
                txt_misol.text = "$number1 - $number2 = "
                javob = number1 - number2
            }
            2 -> {
                txt_misol.text = "$number1 * $number2 = "
                javob = number1 * number2
            }
            3 -> {
                try {
                    if (number1 % number2 != 0) throw Exception()
                    txt_misol.text = "$number1 / $number2 = "
                    javob = number1 / number2
                } catch (e: Exception) {
                    random()
                }
            }
        }
        radEkranYoz()
    }

    fun randomSonAniqla() {
        random1 = Random().nextInt(20)
        random2 = Random().nextInt(20)
        random3 = Random().nextInt(20)

        if (random1 == random2 || random2 == random3 || random1 == random3) {
            randomSonAniqla()
        }
    }

    fun radEkranYoz() {
        var tj = Random().nextInt(4)

        when (tj) {
            0 -> {
                rad_a.text = javob.toString()
                rad_b.text = random1.toString()
                rad_c.text = random2.toString()
                rad_d.text = random3.toString()
            }
            1 -> {
                rad_b.text = javob.toString()
                rad_a.text = random1.toString()
                rad_c.text = random2.toString()
                rad_d.text = random3.toString()
            }
            2 -> {
                rad_c.text = javob.toString()
                rad_b.text = random1.toString()
                rad_a.text = random2.toString()
                rad_d.text = random3.toString()
            }
            3 -> {
                rad_d.text = javob.toString()
                rad_b.text = random1.toString()
                rad_c.text = random2.toString()
                rad_a.text = random3.toString()

                randomSonAniqla()
            }
        }
    }
}