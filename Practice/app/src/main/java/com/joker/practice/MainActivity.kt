package com.joker.practice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Timer
import kotlin.concurrent.timer
import java.util.Random
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tv_random: TextView = findViewById(R.id.tv_random)
        val tv_timer: TextView = findViewById(R.id.tv_timer)
        val tv_point: TextView = findViewById(R.id.tv_point)
        val btn: Button = findViewById(R.id.btn_main)

        val random_box = Random()
        val num = random_box.nextInt(1001)
        tv_random.text = ((num.toFloat()/100)).toString()

        var isRunning = false
        var timerTask: Timer? = null
        var sec = 0.0
        btn.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) {
                timerTask = timer(period = 10) {
                    sec++
                    runOnUiThread {
                        tv_timer.text = ((sec/100)).toString()
                    }
                }
            } else {
                timerTask?.cancel()
                val point = abs(sec-num).toFloat()/100
                tv_point.text = point.toString()
            }
        }
    }
}