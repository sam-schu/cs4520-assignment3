package com.cs4520.assignment3.state

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    val result = MutableLiveData<Double?>()

    fun onAdd(op1: Double, op2: Double) {
        updateResult(op1 + op2)
    }

    fun onSubtract(op1: Double, op2: Double) {
        updateResult(op1 - op2)
    }

    fun onMultiply(op1: Double, op2: Double) {
        updateResult(op1 * op2)
    }

    fun onDivide(op1: Double, op2: Double) {
        updateResult(op1 / op2)
    }

    private fun updateResult(calculationResult: Double) {
        result.value = if (calculationResult.isFinite()) calculationResult else null
    }
}