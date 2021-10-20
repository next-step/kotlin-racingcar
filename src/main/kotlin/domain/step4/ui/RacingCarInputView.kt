package domain.step4.ui

import global.strategy.input.InputStrategy

class RacingCarInputView(private val inputStrategy: InputStrategy) {
    fun numberOfCars(): String {
        println("자동차 대수는 몇 대인가요?")
        return inputStrategy.execute() ?: throw IllegalArgumentException()
    }

    fun numberOfAttempts(): String {
        println("시도할 횟수는 몇 회인가요?")
        return inputStrategy.execute() ?: throw IllegalArgumentException()
    }
}
