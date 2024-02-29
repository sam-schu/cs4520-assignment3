package com.cs4520.assignment3.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

sealed interface CalculationResult

data object InvalidInput : CalculationResult
data object OperationFailed : CalculationResult
data object DivisionByZero : CalculationResult

data class ValidResult(val calculatedValue: Double) : CalculationResult

class CalculatorViewModel : ViewModel() {
    private val _result = MutableLiveData<CalculationResult>()
    val result: LiveData<CalculationResult> = _result

    fun onAdd(op1: String, op2: String) {
        try {
            updateResultWith(op1.toDouble() + op2.toDouble())
        } catch (e: NumberFormatException) {
            _result.value = InvalidInput
        }
    }

    fun onSubtract(op1: String, op2: String) {
        try {
            updateResultWith(op1.toDouble() - op2.toDouble())
        } catch (e: NumberFormatException) {
            _result.value = InvalidInput
        }
    }

    fun onMultiply(op1: String, op2: String) {
        try {
            updateResultWith(op1.toDouble() * op2.toDouble())
        } catch (e: NumberFormatException) {
            _result.value = InvalidInput
        }
    }

    fun onDivide(op1: String, op2: String) {
        try {
            val dividend = op1.toDouble()
            val divisor = op2.toDouble()
            if (divisor == 0.0) {
                _result.value = DivisionByZero
            } else {
                updateResultWith(dividend / divisor)
            }
        } catch (e: NumberFormatException) {
            _result.value = InvalidInput
        }
    }

    private fun updateResultWith(calculatedValue: Double) {
        _result.value = if (calculatedValue.isFinite()) {
            ValidResult(calculatedValue)
        } else {
            OperationFailed
        }
    }
}