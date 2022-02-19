package com.rief

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rief.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	lateinit var binding: ActivityMainBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		loadData()
		
		binding.apply {
			button.setOnClickListener {
				saveData()
			}
		}
	}
	
	fun saveData() {
		val insertText = binding.edtText.text.toString()
		binding.tvText.text = insertText
		
		val sharedPreferences = getSharedPreferences("sharePrefs", Context.MODE_PRIVATE)
		val editor = sharedPreferences.edit()
		editor.apply {
			putString("String_Key", insertText)
//			putBoolean("Boolean_Key", binding.switch1.isChecked)
		}.apply()
		
		
		Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
	}
	
	fun loadData() {
		val sharedPreferences = getSharedPreferences("sharePrefs", Context.MODE_PRIVATE)
		val savedString = sharedPreferences.getString("String_Key", null)
//		val savedBoolean = sharedPreferences.getBoolean("Boolean_key", false)
		
//		binding.apply {
//			tvText.text = savedString
//			switch1.isChecked = savedBoolean
//		}
	}
}