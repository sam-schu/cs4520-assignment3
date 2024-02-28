package com.cs4520.assignment3.view

import android.os.Bundle
import android.view.View
import com.cs4520.assignment3.R
import com.cs4520.assignment3.state.CalculatorPresenter
import com.cs4520.assignment3.state.Presenter

/**
 * The fragment to display the MVP (model-view-presenter) implementation of the calculator.
 */
class MVPFragment : AbstractCalculatorFragment(R.color.mvp_fragment_background), MVPCalculatorView {
    private lateinit var presenter: CalculatorPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = Presenter()
        presenter.setView(this)
    }
    override fun performAdd(op1: String, op2: String) {
        presenter.onAdd(op1, op2)
    }

    override fun performSubtract(op1: String, op2: String) {
        presenter.onSubtract(op1, op2)
    }

    override fun performMultiply(op1: String, op2: String) {
        presenter.onMultiply(op1, op2)
    }

    override fun performDivide(op1: String, op2: String) {
        presenter.onDivide(op1, op2)
    }

    override fun invalidOrMissingInput() {
        showInvalidOrMissingInputMsg()
    }

    override fun newResult(result: Double) {
        updateResult(result)
    }

    override fun newInvalidResult() {
        showInvalidResultMsg()
    }

    override fun divideByZero() {
        showDivideByZeroMsg()
    }
}