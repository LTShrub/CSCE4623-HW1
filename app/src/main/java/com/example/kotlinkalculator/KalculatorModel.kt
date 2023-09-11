package com.example.kotlinkalculator

import net.objecthunter.exp4j.ExpressionBuilder

    class KalculatorModel {
    private var currentInput: String = ""
    private var previousInput: String = ""

    fun appendToInput(input: String) {
        currentInput += input
    }

    fun deleteLastInput(){
        if (currentInput.isNotEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length - 1)
        }
    }

    fun getCurrentInputAsString(): String {
        return currentInput
    }

    fun getPreviousInputAsString(): String {
        return previousInput
    }

    fun clearInput() {
        currentInput = ""
    }

    fun doMath() {
        try {
            val expression = ExpressionBuilder(currentInput).build()
            previousInput = currentInput
            currentInput = (expression.evaluate()).toString()
        } catch (e: Exception) {
            null // Handle invalid expressions
        }
    }
}