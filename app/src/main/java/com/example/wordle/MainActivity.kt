package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wordList = BufferedReader(InputStreamReader(resources.openRawResource(
            resources.getIdentifier("wordle", "raw", packageName)
            ))).readLines()


        fun selectWord(): String {
            return wordList.random()
        }

        val game_message = findViewById<TextView>(R.id.message)
        val selectedWord = selectWord()
        game_message.text = getString(R.string.debug_text, selectedWord)




    }
    // Track the cursor position in the Wordle grid
    private var row = 1
    private var col = 1
    // get textView (e.g., textView23) corresponding row and column
    private fun getTextView(row : Int, col : Int): TextView {
        // e.g., idName is textView31
        val idName = if (col > 5) "textView${row}5" else "textView${row}${col}"
        // resources.getIdentifier will return corresponding number (e.g.,2131231192)
        val id = resources.getIdentifier(idName, "id", packageName)
        //println("idName is $idName and id is $id") //for debugging
        return findViewById<TextView>(id)
    }

    // get letter button (e.g., buttonS, buttonQ)
    private fun getButton(letter : String): Button {
        // e.g., idName is buttonA, buttonB, buttonC, etc
        val idName = "button${letter.uppercase()}"
        // resources.getIdentifier will return corresponding number (e.g., 2131231192)
        val id = resources.getIdentifier(idName, "id", packageName)
        return findViewById<Button>(id)
    }
}
