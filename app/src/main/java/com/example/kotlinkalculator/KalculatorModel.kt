package com.example.kotlinkalculator

import net.objecthunter.exp4j.ExpressionBuilder

    class KalculatorModel {
    private var currentInput: String = ""
    private var previousInput: String = ""

    //Append the text from the selected key onto the current operation string
    fun appendToInput(input: String) {
        currentInput += input
    }

    //Remove the last input by deleting the last character of the string
    fun deleteLastInput(){
        if (currentInput.isNotEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length - 1)
        }
    }

    //Return the current operation string to the presenter
    fun getCurrentInputAsString(): String {
        return currentInput
    }

    //Get the previous input to put into the secondary window
    fun getPreviousInputAsString(): String {
        return previousInput
    }

    //Clear the current input in the window
    fun clearInput() {
        currentInput = ""
    }

    //Change the sign of the current number and if none is present append the sign to the empty string
    fun changeSign() {
        if(currentInput.isEmpty()) {
            currentInput += "-"
            return
        }
        currentInput = if(currentInput[0] == '-'){
            currentInput.substring(1)
        }else{
            "-$currentInput"
        }
    }

    //Primary calculation function read in the current operation string and parse it through the library
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