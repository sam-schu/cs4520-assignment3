package com.cs4520.assignment3.view

interface MVPCalculatorView {
    fun invalidOrMissingInput()

    fun newResult(result: Double)

    fun newInvalidResult()

    fun divideByZero()
}