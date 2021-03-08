package racingcar.ui

import input.InputStrategy

class InputView(question: String, private val inputStrategy: InputStrategy) {
    val value = tryUserInput(question)

    private fun tryUserInput(question: String): String {
        println(question)
        return inputStrategy.enter()
            ?: throw IllegalArgumentException("입력값이 비어 있습니다")
    }
}
