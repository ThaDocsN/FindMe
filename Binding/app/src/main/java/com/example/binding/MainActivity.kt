package com.example.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val myName:MyName = MyName("Charmyrreah Johnson")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        this.setUpButton()
    }

    private fun setUpButton() {
        binding.playButton.setOnClickListener {
            addName()
        }
    }

    private fun addName() {
        binding.apply {
            myName?.nickName = "MaMa"
            invalidateAll()
        }
    }
}