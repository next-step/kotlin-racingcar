package step3.view

import step3.entity.RaceCondition

class InputView {
    operator fun invoke(): RaceCondition {
        val numberOfCars = getNumberInput("자동차 대수는 몇 대인가요?")
        val numberOfLabs = getNumberInput("시도할 횟수는 몇 회인가요?")
        return RaceCondition.of(numberOfCars, numberOfLabs)
    }

    private fun getNumberInput(msg: String): String? {
        println(msg)
        return readLine()
    }
}
