package com.prmto.inviodocuments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.prmto.inviodocuments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MainActivity", "onCreate")

        binding.btnRunMultiwindowModeWithYouTube.setOnClickListener {
            startMultiWindowModeWithYoutubeApp()
        }

        binding.btnRunMultiWindowModeWithUrl.setOnClickListener {
            startMultiWindowModeWithUrl()
        }

        binding.btnEnterPictureInPictureMode.setOnClickListener {
            enterPictureInPictureMode()
        }
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        return when (keyCode) {
            KeyEvent.KEYCODE_SPACE -> {
                Toast.makeText(this, "run Space", Toast.LENGTH_SHORT).show()
                true
            }

            KeyEvent.KEYCODE_W -> {
                Toast.makeText(this, "run W", Toast.LENGTH_SHORT).show()
                true
            }

            KeyEvent.KEYCODE_A -> {
                Toast.makeText(this, "run A", Toast.LENGTH_SHORT).show()
                true
            }

            KeyEvent.KEYCODE_C -> {
                if (event.isCtrlPressed) {
                    Toast.makeText(this, "run Ctrl + C", Toast.LENGTH_SHORT).show()
                    true
                } else {
                    Toast.makeText(this, "run C", Toast.LENGTH_SHORT).show()
                    true
                }
            }

            else -> super.onKeyUp(keyCode, event)
        }
    }

    override fun onTopResumedActivityChanged(topResumed: Boolean) {
        if (topResumed) {
            Log.d("MainActivity", "onTopResumedActivityChanged On the top Resume")
        } else {
            Log.d("MainActivity", "onTopResumedActivityChanged Not on the Top")
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }


    private fun startMultiWindowModeWithYoutubeApp() {
        Intent(Intent.ACTION_MAIN).apply {
            `package` = "com.google.android.youtube"
            addFlags(
                Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT or
                        Intent.FLAG_ACTIVITY_NEW_TASK
            )
        }.also { intent ->
            startActivity(intent)
        }
    }

    private fun startMultiWindowModeWithUrl() {
        Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://www.google.com/")
            addFlags(
                Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT or
                        Intent.FLAG_ACTIVITY_NEW_TASK
            )
        }.also { intent ->
            startActivity(intent)
        }
    }
}