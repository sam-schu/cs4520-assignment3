package com.cs4520.assignment3.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Represents the result of an attempted calculation. Can be one of:
 * - InvalidInput (an input was missing or not a number)
 * - DivisionByZero
 * - OperationFailed (the result was infinity/NaN)
 * - ValidResult, with the associated calculated result value
 */
sealed interface CalculationResult

/**
 * Represents an invalid result due to one of the inputs' being missing or not a number.
 */
data object InvalidInput : CalculationResult

/**
 * Represents an invalid result due to attempted division by zero.
 */
data object DivisionByZero : CalculationResult

/**
 * Represents an invalid result due to the calculation's returning infinity or NaN.
 */
data object OperationFailed : CalculationResult

/**
 * Represents a valid result, with calculatedValue being the numeric result of the calculation.
 */
data class ValidResult(val calculatedValue: Double) : CalculationResult

/**
 * A view model for the MVVM implementation of the calculator that performs calculations and stores
 * the most recent attempted calculation result.
 */
class CalculatorViewModel : ViewModel() {
    private val _result = MutableLiveData<CalculationResult>()

    /**
     * Stores the result of the most recent attempted calculation as a CalculationResult.
     */
    val result: LiveData<CalculationResult> = _result

    /**
     * Attempts to calculate the result of adding the two numeric operands given as strings, and
     * updates the stored result accordingly.
     */
    fun onAdd(op1: String, op2: String) {
        try {
            updateResultWith(op1.toDouble() + op2.toDouble())
        } catch (e: NumberFormatException) {
            _result.value = InvalidInput
        }
    }

    /**
     * Attempts to calculate the result of subtracting the two numeric operands given as strings,
     * and updates the stored result accordingly.
     */
    fun onSubtract(op1: String, op2: String) {
        try {
            updateResultWith(op1.toDouble() - op2.toDouble())
        } catch (e: NumberFormatException) {
            _result.value = InvalidInput
        }
    }

    /**
     * Attempts to calculate the result of multiplying the two numeric operands given as strings,
     * and updates the stored result accordingly.
     */
    fun onMultiply(op1: String, op2: String) {
        try {
            updateResultWith(op1.toDouble() * op2.toDouble())
        } catch (e: NumberFormatException) {
            _result.value = InvalidInput
        }
    }

    /**
     * Attempts to calculate the result of dividing the two numeric operands given as strings, and
     * updates the stored result accordingly.
     */
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

    // Stores the calculation result represented by the given value, based on whether it is a valid
    // number or infinity/NaN
    private fun updateResultWith(calculatedValue: Double) {
        _result.value = if (calculatedValue.isFinite()) {
            ValidResult(calculatedValue)
        } else {
            OperationFailed
        }
    }
}