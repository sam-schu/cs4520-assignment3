package com.cs4520.assignment3.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.R
import com.cs4520.assignment3.state.CalculatorViewModel
import com.cs4520.assignment3.state.DivisionByZero
import com.cs4520.assignment3.state.InvalidInput
import com.cs4520.assignment3.state.OperationFailed
import com.cs4520.assignment3.state.ValidResult

/**
 * The fragment to display the MVVM (model-view-viewmodel) implementation of the calculator.
 */
class MVVMFragment : AbstractCalculatorFragment(R.color.mvvm_fragment_background) {
    private lateinit var viewModel: CalculatorViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        viewModel.result.observe(viewLifecycleOwner) {
            when (it) {
                is InvalidInput -> showInvalidOrMissingInputMsg()
                is DivisionByZero -> showDivideByZeroMsg()
                is OperationFailed -> showInvalidResultMsg()
                is ValidResult -> updateResult(it.calculatedValue)
            }
        }
    }
    override fun performAdd(op1: String, op2: String) {
        viewModel.onAdd(op1, op2)
    }

    override fun performSubtract(op1: String, op2: String) {
        viewModel.onSubtract(op1, op2)
    }

    override fun performMultiply(op1: String, op2: String) {
        viewModel.onMultiply(op1, op2)
    }

    override fun performDivide(op1: String, op2: String) {
        viewModel.onDivide(op1, op2)
    }
}