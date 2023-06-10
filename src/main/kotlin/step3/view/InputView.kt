package step3.view

import step3.entity.RaceCondition

class InputView {
    operator fun invoke(): RaceCondition {
        val nameOfCars = getInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val numberOfLabs = getInput("시도할 횟수는 몇 회인가요?")
        return RaceCondition.of(nameOfCars, numberOfLabs)
    }

    private fun getInput(msg: String): String? {
        println(msg)
        return readLine()
    }
}
