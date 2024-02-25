package com.cs4520.assignment3.logic

import com.cs4520.assignment3.view.MVPCalculatorView

interface CalculatorPresenter {
    fun setView(view: MVPCalculatorView)

    fun onAdd(op1: Double, op2: Double)

    fun onSubtract(op1: Double, op2: Double)

    fun onMultiply(op1: Double, op2: Double)

    fun onDivide(op1: Double, op2: Double)
}