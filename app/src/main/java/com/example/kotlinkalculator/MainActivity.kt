package com.example.kotlinkalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity(),KalculatorContract.View, View.OnClickListener  {
    private lateinit var mPresenter: KalculatorPresenter
    private lateinit var bigView: TextView
    private lateinit var smallView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        bigView = findViewById(R.id.bigView)
        smallView = findViewById(R.id.smallView)

        mPresenter = KalculatorPresenter()
        mPresenter.setView(this)
        mPresenter.start()

        // Initialize button click listeners for all buttons
        val buttonIds = arrayOf(
            R.id.buttonAC, R.id.buttonDecimal, R.id.buttonDivide, R.id.buttonMultiply,
            R.id.buttonPlus, R.id.buttonMinus, R.id.buttonNine, R.id.buttonEight,
            R.id.buttonSeven, R.id.buttonSix, R.id.buttonFive, R.id.buttonFour,
            R.id.buttonThree, R.id.buttonTwo, R.id.buttonOne, R.id.buttonZero,
            R.id.buttonDelete, R.id.buttonEquals, R.id.buttonNegative
        )

        for (buttonId in buttonIds) {
            findViewById<Button>(buttonId).setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) {
        view?.let {
            val button = it as Button
            val input = button.text.toString()
            mPresenter.append(input)
        }
    }

    override fun displayResult(result: String) {
        bigView.text = result
    }

    override fun displayPrevious(lastResult: String) {
        smallView.text = lastResult
    }

}
