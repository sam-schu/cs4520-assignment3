package com.cs4520.assignment3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.R
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
        binding.resultText.visibility = View.INVISIBLE

        binding.addButton.setOnClickListener(::buttonClicked)
        binding.subtractButton.setOnClickListener(::buttonClicked)
        binding.multiplyButton.setOnClickListener(::buttonClicked)
        binding.divideButton.setOnClickListener(::buttonClicked)
    }

    private fun buttonClicked(viewClicked: View) {
        val op1: String = binding.numberInput1.text.toString()
        val op2: String = binding.numberInput2.text.toString()

        binding.numberInput1.setText("")
        binding.numberInput2.setText("")

        performOp(viewClicked, op1, op2)
    }

    private fun performOp(viewClicked: View, op1: String, op2: String) {
        when (viewClicked) {
            binding.addButton -> performAdd(op1, op2)
            binding.subtractButton -> performSubtract(op1, op2)
            binding.multiplyButton -> performMultiply(op1, op2)
            binding.divideButton -> performDivide(op1, op2)
        }
    }

    protected fun updateResult(result: Double) {
        binding.resultText.text = getString(R.string.result_text, result)
        binding.resultText.visibility = View.VISIBLE
    }

    protected fun showInvalidOrMissingInputMsg() {
        Toast.makeText(context, R.string.invalid_number_input_msg, Toast.LENGTH_LONG).show()
    }

    protected fun showInvalidResultMsg() {
        Toast.makeText(context, R.string.invalid_result_msg, Toast.LENGTH_LONG).show()
    }

    protected fun showDivideByZeroMsg() {
        Toast.makeText(context, R.string.divide_by_zero_msg, Toast.LENGTH_LONG).show()
    }

    protected abstract fun performAdd(op1: String, op2: String)

    protected abstract fun performSubtract(op1: String, op2: String)

    protected abstract fun performMultiply(op1: String, op2: String)

    protected abstract fun performDivide(op1: String, op2: String)
}