package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lateinit var binding: ActivityMainBinding
    private lateinit var mainBinding:ActivityMainBinding
    private val myName = MyName("Charles")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set content view
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainBinding.myName = myName

        mainBinding.doneButton.setOnClickListener {
            addNickName(it)
        }
      /*  binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }*/
    }

    private fun addNickName(view: View) {
     /*   binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameText.visibility = View.VISIBLE
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE*/

        mainBinding.apply {
            myName?.nickName = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}