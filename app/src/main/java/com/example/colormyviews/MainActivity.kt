package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.colormyviews.ui.theme.ColorMyViewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            findViewById(R.id.txt_box_one),
            findViewById(R.id.txt_box_two),
            findViewById(R.id.txt_box_three),
            findViewById(R.id.txt_box_four),
            findViewById(R.id.txt_box_five),
            findViewById(R.id.const_layout),
            findViewById(R.id.btn_red),
            findViewById(R.id.btn_yellow),
            findViewById(R.id.btn_green)
        )

        for (view in clickableViews) {
            view.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.txt_box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.txt_box_two -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.txt_box_three -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.txt_box_four -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.txt_box_five -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.btn_red -> findViewById<TextView>(R.id.txt_box_three).setBackgroundResource(R.color.red)
            R.id.btn_yellow -> findViewById<TextView>(R.id.txt_box_four).setBackgroundResource(R.color.yellow)
            R.id.btn_green -> findViewById<TextView>(R.id.txt_box_five).setBackgroundResource(R.color.green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}