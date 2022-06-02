package com.rief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.rief.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnChoose.setOnClickListener {
                val checkedId = radioGroup.checkedRadioButtonId
                var message  = " "
                when (checkedId) {
                    R.id.cValueOne -> {
                        message = "Value 1"
                    }
                    R.id.cValueTwo -> {
                        message = "Value 2"
                    }
                    R.id.cValueThree -> {
                        message = "Value 3"
                    }
                    -1 -> {
                        message = "No Value"
                    }
                }
                tvValue.text = message
            }

            btnReset.setOnClickListener {
                radioGroup.clearCheck()
            }

            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                val rb = findViewById<RadioButton>(checkedId)
                when (rb != null) {
                    true -> Toast.makeText(this@MainActivity, "${rb.text}", Toast.LENGTH_SHORT).show()
                    false -> Toast.makeText(this@MainActivity, "No Value", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}