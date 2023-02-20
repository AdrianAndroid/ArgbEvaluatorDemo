package com.notification.argbevaluatordemo

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.startRun).setOnClickListener {
            displayColors()
        }
    }

    var animation: ValueAnimator? = null
    private fun displayColors() {
        val display = findViewById<View>(R.id.display)
        animation = ObjectAnimator.ofInt(
            display,
            "backgroundColor",
            Color.rgb(0, 115, 255),
            Color.rgb(125, 74, 235),
            Color.rgb(221, 55, 143),
            Color.rgb(234, 85, 54)
        )
        animation?.let { it ->
            it.duration = 3000
            it.repeatCount = 1
            it.setEvaluator(ArgbEvaluator())
            it.repeatMode = ValueAnimator.REVERSE
            it.addUpdateListener { value ->
                window.statusBarColor = value.animatedValue as Int
            }
            it.start()
        }
    }
}