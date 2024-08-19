package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Android Developer")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // TODO: setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

       // TODO: findViewById<Button>(R.id.done_button).setOnClickListener {
       // TODO: addNickName(it)
       // TODO: }

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun addNickName(view: View) {

        // TODO: val editText = findViewById<EditText>(R.id.nickname_edit)
        // TODO: val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        // TODO: nicknameTextView.text = editText.text
        // TODO: editText.visibility = View.VISIBLE

        // TODO: view.visibility = View.GONE
        // TODO: nicknameTextView.visibility = View.VISIBLE

        binding.apply {

            // TODO: binding.nicknameText.text = binding.nicknameEdit.text

            myName?.nickname = nicknameEdit.text.toString()
            binding.nicknameEdit.visibility = View.GONE

            invalidateAll()

            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE

        }

        // TODO: Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}