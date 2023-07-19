package com.prmto.inviodocuments

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.uiMode == Configuration.UI_MODE_NIGHT_YES) {
            Toast.makeText(this, "Dark Mode", Toast.LENGTH_SHORT).show()
        } else if (newConfig.uiMode == Configuration.UI_MODE_NIGHT_NO) {
            Toast.makeText(this, "Light Mode", Toast.LENGTH_SHORT).show()
        }
    }
}