package domain.step4.ui

import global.strategy.input.InputStrategy

class RacingCarInputView(private val inputStrategy: InputStrategy) {
    fun numberOfCars(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return inputStrategy.execute() ?: throw IllegalArgumentException()
    }

    fun numberOfAttempts(): String {
        println("시도할 횟수는 몇 회인가요?")
        return inputStrategy.execute() ?: throw IllegalArgumentException()
    }
}
