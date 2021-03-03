package racingcar.ui

import input.InputStrategy

class InputView(question: String, private val inputStrategy: InputStrategy) {
    val value: Int

    init {
        value = tryUserInput(question)
    }

    private fun tryUserInput(question: String): Int {
        println(question)
        val inputString = inputStrategy.enter()
            ?: throw IllegalArgumentException("입력값이 비어 있습니다")
        return validate(inputString.toIntOrNull() ?: throw NumberFormatException("입력값이 정수가 아닙니다"))
    }

    private fun validate(inputValue: Int): Int {
        if (inputValue < 1) {
            throw IllegalArgumentException("입력값은 1보다 커야 합니다")
        }
        return inputValue
    }
}
