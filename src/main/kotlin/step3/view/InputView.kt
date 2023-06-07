package step3.view

import step3.entity.RaceCondition

class InputView {
    operator fun invoke(): RaceCondition {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCars = readLine()
        println("시도할 횟수는 몇 회인가요?")
        val numberOfLabs = readLine()
        return RaceCondition.of(numberOfCars, numberOfLabs)
    }
}
