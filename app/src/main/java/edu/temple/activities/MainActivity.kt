package edu.temple.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent


//const val = "somekeyvalue"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an array of text sizes (multiples of 5)
        val textSizes = Array(20) { (it + 1) * 5 }
        Log.d("MainActivity", "Available text sizes: ${textSizes.contentToString()}")

        val recyclerView = findViewById<RecyclerView>(R.id.textSizeSelectorRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = TextSizeAdapter(textSizes) { selectedSize ->
            Log.d("MainActivity", "Selected text size: $selectedSize")

            // Start DisplayActivity and pass the selected size
            val intent = Intent(this, DisplayActivity::class.java).apply {
                putExtra("TEXT_SIZE", selectedSize.toFloat()) // Ensure float value
            }
            startActivity(intent)
        }
    }
}


    /* Convert to RecyclerView.Adapter */
    class TextSizeAdapter(
        private val textSizes: Array<Int>,
        private val callback: (Int) -> Unit
    ) : RecyclerView.Adapter<TextSizeAdapter.TextSizeViewHolder>() {

        inner class TextSizeViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {
            init {
                textView.setOnClickListener {
                    callback(textSizes[adapterPosition]) // Pass selected size
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextSizeViewHolder {
            return TextSizeViewHolder(TextView(parent.context).apply {
                setPadding(5, 20, 0, 20)
            })
        }

        override fun onBindViewHolder(holder: TextSizeViewHolder, position: Int) {
            holder.textView.apply {
                text = textSizes[position].toString()
                textSize = textSizes[position].toFloat()
            }
        }

        override fun getItemCount(): Int = textSizes.size
    }









