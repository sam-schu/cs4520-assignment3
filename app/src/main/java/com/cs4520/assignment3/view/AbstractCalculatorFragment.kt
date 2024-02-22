package com.cs4520.assignment3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.CalculatorLayoutBinding

abstract class AbstractCalculatorFragment(private val backgroundResource: Int) : Fragment() {
    private lateinit var binding: CalculatorLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return CalculatorLayoutBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.setBackgroundResource(backgroundResource)

        binding.addButton.setOnClickListener(::buttonClicked)
        binding.subtractButton.setOnClickListener(::buttonClicked)
        binding.multiplyButton.setOnClickListener(::buttonClicked)
        binding.divideButton.setOnClickListener(::buttonClicked)
    }

    private fun buttonClicked(v: View) {
        try {
            val op1: Double = getDoubleFrom(binding.numberInput1, 1)
            val op2: Double = getDoubleFrom(binding.numberInput2, 2)

            performOp(v, op1, op2)
        } catch (e: NumberFormatException) {
            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
        } finally {
            clearInputs()
        }
    }

    private fun getDoubleFrom(textField: EditText, fieldNo: Int): Double {
        try {
            return textField.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("Number input $fieldNo is not a valid number. Please try again.")
        }
    }

    private fun clearInputs() {
        binding.numberInput1.setText("")
        binding.numberInput2.setText("")
    }

    private fun performOp(viewClicked: View, op1: Double, op2: Double) {
        when (viewClicked) {
            binding.addButton -> performAdd(op1, op2)
            binding.subtractButton -> performSubtract(op1, op2)
            binding.multiplyButton -> performMultiply(op1, op2)
            binding.divideButton -> performDivide(op1, op2)
        }
    }

    abstract fun performAdd(op1: Double, op2: Double)

    abstract fun performSubtract(op1: Double, op2: Double)

    abstract fun performMultiply(op1: Double, op2: Double)

    abstract fun performDivide(op1: Double, op2: Double)
}