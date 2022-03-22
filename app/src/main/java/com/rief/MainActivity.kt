package com.rief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.rief.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.edtName.text

            when {
                TextUtils.isEmpty(name) -> {
                    binding.edtName.requestFocus()
                    binding.edtName.text.trim()
                }
            }
        
        binding.btnClick.setOnClickListener {
            Toast.makeText(this, "$name", Toast.LENGTH_LONG).show()
        }
    }
}