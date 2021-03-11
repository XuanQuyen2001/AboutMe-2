package com.example.aboutmeapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnDone).setOnClickListener{
            addNickName(it)
        }

        findViewById<TextView>(R.id.nickName_txt).setOnClickListener{
            updateNickname(it)
        }

    }
    private fun clickHandlerFunction(viewThatIsClicked: View) {


    }
    private fun addNickName(view: View){
        val editText = findViewById<EditText>(R.id.nickName_edit)
        val nickName_txt = findViewById<TextView>(R.id.nickName_txt)
        nickName_txt.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nickName_txt.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nickName_edit)
        val btnDone = findViewById<Button>(R.id.btnDone)
        editText.visibility = View.GONE
        btnDone.visibility = View.GONE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

}