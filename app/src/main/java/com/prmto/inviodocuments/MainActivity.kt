package com.prmto.inviodocuments

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.window.layout.WindowMetricsCalculator
import com.prmto.inviodocuments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        computeWindowSizeClasses()
    }

    private fun computeWindowSizeClasses() {
        val metrics = WindowMetricsCalculator.getOrCreate()
            .computeCurrentWindowMetrics(this)

        val widthDp = metrics.bounds.width() /
                resources.displayMetrics.density
        val widthWindowSizeClass = when {
            widthDp < 600f -> WindowSizeClass.COMPACT
            widthDp < 840f -> WindowSizeClass.MEDIUM
            else -> WindowSizeClass.EXPANDED
        }

        val heightDp = metrics.bounds.height() /
                resources.displayMetrics.density
        val heightWindowSizeClass = when {
            heightDp < 480f -> WindowSizeClass.COMPACT
            heightDp < 900f -> WindowSizeClass.MEDIUM
            else -> WindowSizeClass.EXPANDED
        }

        Log.d("WindowSizeClass", "Width: $widthWindowSizeClass, Height: $heightWindowSizeClass")
    }
}

enum class WindowSizeClass { COMPACT, MEDIUM, EXPANDED }