package com.cs4520.assignment3.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.R
import com.cs4520.assignment3.state.CalculatorViewModel

/**
 * The fragment to display the MVVM (model-view-viewmodel) implementation of the calculator.
 */
class MVVMFragment : AbstractCalculatorFragment(R.color.mvvm_fragment_background) {
    private lateinit var viewModel: CalculatorViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        viewModel.result.observe(viewLifecycleOwner) {
            if (it == null) showInvalidResultMsg() else updateResult(it)
        }
    }
    override fun performAdd(op1: Double, op2: Double) {
        viewModel.onAdd(op1, op2)
    }

    override fun performSubtract(op1: Double, op2: Double) {
        viewModel.onSubtract(op1, op2)
    }

    override fun performMultiply(op1: Double, op2: Double) {
        viewModel.onMultiply(op1, op2)
    }

    override fun performDivide(op1: Double, op2: Double) {
        viewModel.onDivide(op1, op2)
    }
}