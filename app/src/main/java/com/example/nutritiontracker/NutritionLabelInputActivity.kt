package com.example.nutritiontracker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * This Activity is for entering a new item's nutrition information to be used in the ComputeMealNutritionActivity
 */
class NutritionLabelInputActivity : AppCompatActivity(), UIActivity {
    private lateinit var itemName: EditText
    private lateinit var servingSize: EditText
    private lateinit var calories: EditText
    private lateinit var protein: EditText
    private lateinit var fiber: EditText
    private lateinit var sugars: EditText
    private lateinit var carbs: EditText
    private lateinit var submit: Button
    private lateinit var nutritionLabel: NutritionLabel

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nutrition_label_input)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nutritionLabelInput)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun setupViews() {
        itemName = findViewById(R.id.itemName)
        servingSize = findViewById(R.id.servingSize)
        calories = findViewById(R.id.calories)
        protein = findViewById(R.id.protein)
        fiber = findViewById(R.id.fiber)
        sugars = findViewById(R.id.sugars)
        carbs = findViewById(R.id.carbs)
        submit = findViewById(R.id.submitButton)

        submit.setOnClickListener {
            processInputs()
        }
    }

    /**
     * Processes the user inputs and creates a NutritionLabel Object from the data provided.
     */
    fun processInputs() {
        if (itemName.text.toString().isNotEmpty() && servingSize.text.isNotEmpty() && calories.text.toString().isNotEmpty()) {
            var servingSize =
                NutritionLabel.ServingSize(
                    servingSize.text.toString().toInt(),
                    NutritionLabel.ServingSize.Type.GRAMS
                )
            var list = listOf<Macro>(
                Macro(Macro.Type.CALORIES, calories.text.toString().toInt()),
                Macro(Macro.Type.PROTEIN, protein.text.toString().toInt()),
                Macro(Macro.Type.FIBER, fiber.text.toString().toInt()),
                Macro(Macro.Type.ADDED_SUGARS, sugars.text.toString().toInt()),
                Macro(Macro.Type.TOTAL_CARBS, carbs.text.toString().toInt())
            )

            nutritionLabel = NutritionLabel(itemName.text.toString(), servingSize, list);
        }
        else {
            Toast.makeText(this, "Missing Required Information!", Toast.LENGTH_SHORT).show()
        }
    }
}