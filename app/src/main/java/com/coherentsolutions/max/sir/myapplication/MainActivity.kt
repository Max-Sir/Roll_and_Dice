package com.coherentsolutions.max.sir.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton = findViewById<Button>(R.id.main_button)
        rollButton.setOnClickListener {
            roll()
        }
    }


    internal val map = mapOf(
        1 to R.drawable.dice_1,
        2 to R.drawable.dice_2,
        3 to R.drawable.dice_3,
        4 to R.drawable.dice_4,
        5 to R.drawable.dice_5,
        6 to R.drawable.dice_6
    )
}

private fun MainActivity.roll() {
    val img=findViewById<ImageView>(R.id.imageView)
    val unpredictableNumber=Random.nextInt(1, 7)
    map[unpredictableNumber]?.let { img.setImageResource(it) }
    Toast.makeText(this,"rolled dice number is $unpredictableNumber",Toast.LENGTH_SHORT).show()
    findViewById<ConstraintLayout>(R.id.mainConstraintLayout).setBackgroundColor(Color.parseColor("#${createRandomIntegerString(0x08)}"))
    findViewById<Button>(R.id.main_button).setBackgroundColor(Color.parseColor("#${createRandomIntegerString(0x08)}"))
}

internal fun createRandomIntegerString(length: Int): String {
    val stringBuilder = StringBuilder()
    val hexsInterpolation = "0123456789abcdef"
    for (i in 0 until length) {
        val tmpInt = Random.nextInt()
        val x = Math.abs(tmpInt) % 16
        stringBuilder.append(hexsInterpolation[x])
    }
    return stringBuilder.toString()
}