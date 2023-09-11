package com.example.kotlinkalculator

interface KalculatorContract {
    interface View{
        fun displayResult(result: String)
        fun displayPrevious(result: String)
    }

    interface Presenter{
        fun setView(view:View)
        fun start()
        fun append(input: String)
    }
}