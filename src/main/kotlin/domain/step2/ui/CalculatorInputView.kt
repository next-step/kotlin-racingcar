package domain.step2.ui

import global.strategy.input.InputStrategy

class CalculatorInputView(private val inputStrategy: InputStrategy) {
    fun inputExpression(): String? {
        println(INPUT_MESSAGE)
        return inputStrategy.execute()
    }

    companion object {
        const val INPUT_MESSAGE = "===============\n연산식을 입력해주세요\n==============="
    }
}
