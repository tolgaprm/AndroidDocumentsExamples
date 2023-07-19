package com.prmto.inviodocuments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.prmto.inviodocuments.databinding.ActivityMainBinding
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding.root)

        showThirdEditTextIfLanguageIsTr()
    }

    private fun showThirdEditTextIfLanguageIsTr() {
        val currentLanguage = Locale.getDefault().language
        if (currentLanguage == "tr") {
            binding.editTextThird.visibility = View.VISIBLE
        }
    }
}