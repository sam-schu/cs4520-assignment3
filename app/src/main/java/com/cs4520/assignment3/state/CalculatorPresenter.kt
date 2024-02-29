package com.cs4520.assignment3.state

import com.cs4520.assignment3.view.MVPCalculatorView

/**
 * A presenter for the MVP implementation of the calculator.
 */
interface CalculatorPresenter {
    /**
     * Sets the view (fragment, activity, or similar) that should be notified to update when a new
     * result is calculated.
     *
     * @param view the view to be notified in the future, or null to not notify any view.
     */
    fun setView(view: MVPCalculatorView?)

    /**
     * Calculates the result of adding the two numeric operands given as strings, and notifies the
     * presenter's associated view of the result.
     */
    fun onAdd(op1: String, op2: String)

    /**
     * Calculates the result of subtracting the two numeric operands given as strings, and notifies
     * the presenter's associated view of the result.
     */
    fun onSubtract(op1: String, op2: String)

    /**
     * Calculates the result of multiplying the two numeric operands given as strings, and notifies
     * the presenter's associated view of the result.
     */
    fun onMultiply(op1: String, op2: String)

    /**
     * Calculates the result of dividing the two numeric operands given as strings, and notifies the
     * presenter's associated view of the result.
     */
    fun onDivide(op1: String, op2: String)
}