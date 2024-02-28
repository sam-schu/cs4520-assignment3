package com.cs4520.assignment3.state

import com.cs4520.assignment3.view.MVPCalculatorView

interface CalculatorPresenter {
    fun setView(view: MVPCalculatorView?)

    fun onAdd(op1: String, op2: String)

    fun onSubtract(op1: String, op2: String)

    fun onMultiply(op1: String, op2: String)

    fun onDivide(op1: String, op2: String)
}