package com.example.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var weightInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var resultText: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        weightInput = findViewById(R.id.weightInput)
        heightInput = findViewById(R.id.heightInput)
        resultText = findViewById(R.id.resultText)
        calculateButton = findViewById(R.id.calculateButton)

        // Set up button click listener
        calculateButton.setOnClickListener { calculateBMI() }
    }

    private fun calculateBMI() {
        // Get user input
        val weight = weightInput.text.toString().toFloatOrNull()
        val height = heightInput.text.toString().toFloatOrNull()

        if (weight != null && height != null && height > 0) {
            // Calculate BMI
            val bmi = weight / (height * height)
            displayResult(bmi)
        } else {
            resultText.text = "Please enter valid weight and height."
        }
    }

    private fun displayResult(bmi: Float) {
        val bmiCategory = when {
            bmi < 18.5 -> "Underweight"
            bmi in 18.5..24.9 -> "Normal weight"
            bmi in 25.0..29.9 -> "Overweight"
            else -> "Obesity"
        }
        resultText.text = String.format("Your BMI: %.2f\nCategory: %s", bmi, bmiCategory)
    }
}
