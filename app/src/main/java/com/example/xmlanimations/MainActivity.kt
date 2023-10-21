package com.example.xmlanimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.xmlanimations.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Load animation from the file
        val stampAnimation = AnimationUtils.loadAnimation(
            this@MainActivity,
            R.anim.exit_up_anim
        )
        binding.root.setOnClickListener {
            // Apply the animation to each star ImageView
            CoroutineScope(Dispatchers.Main).launch {
                delay(500)    // Start animating after 500 millis
                // Apply animation to the View
                binding.ivRocket.startAnimation(stampAnimation)
            }
        }
    }
}