package com.example.xmlanimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.get
import com.example.xmlanimations.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Apply the animation to each star ImageView
        CoroutineScope(Dispatchers.Main).launch {
            delay(500)    // Start animating after 500 millis
            for (i in 0 until 3) { // loop through each Star
                // Get View
                val ivStar = binding.starRating[i] as ImageView
                // Load animation from the file
                val stampAnimation = AnimationUtils.loadAnimation(
                    this@MainActivity,
                    R.anim.stamp_anim
                )
                // Apply animation to the View
                ivStar.startAnimation(stampAnimation)
                delay(400) // Set filled star just before 50 millis of Anim end. PS: 450(Anim duration)
                ivStar.setImageResource(R.drawable.filled_star)
            }
        }
    }
}