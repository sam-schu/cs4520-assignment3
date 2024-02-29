package com.cs4520.assignment3.view

/**
 * A view for the MVP implementation of the calculator.
 */
interface MVPCalculatorView {
    /**
     * Used to update the view if one of the calculation inputs is invalid or missing.
     */
    fun invalidOrMissingInput()

    /**
     * Used to update the view based on the given valid calculation result.
     */
    fun newResult(result: Double)

    /**
     * Used to update the view if the calculation result was invalid.
     */
    fun newInvalidResult()

    /**
     * Used to update the view if division by zero was attempted.
     */
    fun divideByZero()
}