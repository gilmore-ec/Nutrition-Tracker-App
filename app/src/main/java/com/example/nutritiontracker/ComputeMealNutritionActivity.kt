package com.example.nutritiontracker

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * This Activity is for using saved nutrition information to efficiently calculate the nutrition of a meal
 */
class ComputeMealNutritionActivity : AppCompatActivity(), UIActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compute_meal_nutrition)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.computeMealNutrition)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun setupViews() {
        TODO("Not yet implemented")
    }
}