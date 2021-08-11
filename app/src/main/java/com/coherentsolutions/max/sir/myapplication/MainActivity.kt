package com.coherentsolutions.max.sir.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.coherentsolutions.max.sir.myapplication.databinding.ActivityMainBinding
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger
import kotlin.math.abs
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainButton.setOnClickListener {
            roll()

        }
        binding.mainConstraintLayout.setOnClickListener { roll() }

    }

    private fun roll() {
        val img = binding.imageView
        val unpredictableNumber = Random.nextInt(1, 7)
        map[unpredictableNumber]?.let { img.setImageResource(it) }
        val logger=Logger.getLogger("Debug")
        logger.log(Level.INFO,"given $unpredictableNumber")
        Toast.makeText(this, "rolled dice number is $unpredictableNumber", Toast.LENGTH_SHORT)
            .show()
        binding.mainConstraintLayout.setBackgroundColor(
            Color.parseColor(
                "#${
                    createRandomIntegerString(
                        0x08
                    )
                }"
            )
        )
        binding.mainButton.setBackgroundColor(Color.parseColor("#${createRandomIntegerString(0x08)}"))
        binding.invalidateAll()
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


internal fun createRandomIntegerString(length: Int): String {
    val stringBuilder = StringBuilder()
    val hexsInterpolation = "0123456789abcdef"
    for (i in 0 until length) {
        val tmpInt = Random.nextInt()
        val x = abs(tmpInt) % 16
        stringBuilder.append(hexsInterpolation[x])
    }
    return stringBuilder.toString()
}