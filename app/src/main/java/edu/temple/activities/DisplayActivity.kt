package edu.temple.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.util.Log

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val textView = findViewById<TextView>(R.id.lyricsDisplayTextView)

        // Get text size from Intent
        val textSize = intent.getFloatExtra("TEXT_SIZE", -1f)
        Log.d("DisplayActivity", "Received text size: $textSize")

        if (textSize > 0) {
            textView.textSize = textSize // Apply selected text size
        } else {
            Log.e("DisplayActivity", "Invalid text size received: $textSize")
        }
    }
}
