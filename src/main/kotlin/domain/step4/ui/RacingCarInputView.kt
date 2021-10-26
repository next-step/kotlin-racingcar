package domain.step4.ui

import global.strategy.input.InputStrategy

class RacingCarInputView(private val inputStrategy: InputStrategy) {
    fun numberOfCars(): String {
        println(ASK_NAMES)
        return inputStrategy.execute() ?: throw IllegalArgumentException()
    }

    fun numberOfAttempts(): String {
        println(ASK_ATTEMPTS)
        return inputStrategy.execute() ?: throw IllegalArgumentException()
    }

    companion object {
        const val ASK_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val ASK_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
    }
}
