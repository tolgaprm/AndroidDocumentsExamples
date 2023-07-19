package com.prmto.inviodocuments

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.prmto.inviodocuments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.uiMode == Configuration.UI_MODE_NIGHT_YES) {
            Toast.makeText(this, R.string.dark_theme, Toast.LENGTH_SHORT).show()
        } else if (newConfig.uiMode == Configuration.UI_MODE_NIGHT_NO) {
            Toast.makeText(this, R.string.light_theme, Toast.LENGTH_SHORT).show()
        }
    }
}