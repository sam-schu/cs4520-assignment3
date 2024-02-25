package com.cs4520.assignment3.logic

import com.cs4520.assignment3.view.MVPCalculatorView

class Presenter : CalculatorPresenter {
    private var view: MVPCalculatorView? = null
    private var result: Double = 0.0

    override fun setView(view: MVPCalculatorView?) {
        this.view = view
    }

    override fun onAdd(op1: Double, op2: Double) {
        result = op1 + op2
        notifyView()
    }

    override fun onSubtract(op1: Double, op2: Double) {
        result = op1 - op2
        notifyView()
    }

    override fun onMultiply(op1: Double, op2: Double) {
        result = op1 * op2
        notifyView()
    }

    override fun onDivide(op1: Double, op2: Double) {
        result = op1 / op2
        notifyView()
    }

    private fun notifyView() {
        if (result.isFinite()) {
            view?.newResult(result)
        } else {
            view?.newInvalidResult()
        }
    }
}