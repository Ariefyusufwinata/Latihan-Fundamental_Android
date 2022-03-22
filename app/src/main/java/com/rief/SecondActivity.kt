package com.rief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rief.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        var NAME = "NAME"
    }
}