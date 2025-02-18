package edu.temple.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.util.Log

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // TODO Step 3: Extract transferred value and use for lyricsDisplayView text size

        val textSize = intent.getIntExtra("TEXT_SIZE", -1)

        Log.d("DisplayActivity", "Received text size: $textSize")

        val textView = findViewById<TextView>(R.id.lyricsDisplayTextView)
        }
    }

