package com.abalosgeormybryllec.simplecalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.abalosgeormybryllec.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener{ calculateLogic(1) }
        binding.subtractButton.setOnClickListener{ calculateLogic(2) }
        binding.multiplyButton.setOnClickListener{ calculateLogic(3) }
        binding.divideButton.setOnClickListener{ calculateLogic(4) }
    }

    fun calculateLogic(operation : Int){
        var firstNumberText = binding.firstNumber.text.toString()
        var secondNumberText = binding.secondNumber.text.toString()

        if (firstNumberText.isEmpty() || secondNumberText.isEmpty()){
         Toast.makeText(this,"Fill the first and second number text area please !", Toast.LENGTH_SHORT).show()
         return
         }


        var firstNumber = firstNumberText.toIntOrNull()
        var secondNumber = secondNumberText.toIntOrNull()



        if (firstNumber != null && secondNumber != null){
            val result = when(operation) {
                1 -> firstNumber + secondNumber
                2 -> firstNumber - secondNumber
                3 -> firstNumber * secondNumber
                4 -> if (secondNumber != 0) firstNumber / secondNumber else {
                    Toast.makeText(this,"You can not divide any number to zero !", Toast.LENGTH_SHORT).show()
                    return
                }
                else -> 0
            }
            binding.resultText.text = result.toString()
        }
        else{
            Toast.makeText(this,"Please add only numbers", Toast.LENGTH_SHORT).show()
        }
    }
}