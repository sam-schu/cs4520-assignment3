package com.cs4520.assignment3.state

import com.cs4520.assignment3.view.MVPCalculatorView

class Presenter : CalculatorPresenter {
    private var view: MVPCalculatorView? = null
    private var result: Double = 0.0

    override fun setView(view: MVPCalculatorView?) {
        this.view = view
    }

    override fun onAdd(op1: String, op2: String) {
        try {
            result = op1.toDouble() + op2.toDouble()
            notifyViewAfterCalculation()
        } catch (e: NumberFormatException) {
            view?.invalidOrMissingInput()
        }
    }

    override fun onSubtract(op1: String, op2: String) {
        try {
            result = op1.toDouble() - op2.toDouble()
            notifyViewAfterCalculation()
        } catch (e: NumberFormatException) {
            view?.invalidOrMissingInput()
        }
    }

    override fun onMultiply(op1: String, op2: String) {
        try {
            result = op1.toDouble() * op2.toDouble()
            notifyViewAfterCalculation()
        } catch (e: NumberFormatException) {
            view?.invalidOrMissingInput()
        }
    }

    override fun onDivide(op1: String, op2: String) {
        try {
            val dividend = op1.toDouble()
            val divisor = op2.toDouble()
            if (divisor == 0.0) {
                view?.divideByZero()
            } else {
                result = dividend / divisor
                notifyViewAfterCalculation()
            }
        } catch (e: NumberFormatException) {
            view?.invalidOrMissingInput()
        }
    }

    private fun notifyViewAfterCalculation() {
        if (result.isFinite()) {
            view?.newResult(result)
        } else {
            view?.newInvalidResult()
        }
    }
}