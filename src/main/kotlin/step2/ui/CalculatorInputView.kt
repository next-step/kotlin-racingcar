package step2.ui

import step2.strategy.input.InputStrategy

class CalculatorInputView(private val inputStrategy: InputStrategy) {
    fun inputExpression(): String? = inputStrategy.execute()
}
