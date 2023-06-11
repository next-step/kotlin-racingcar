package study.racinggame.ui

import study.racinggame.domain.RacingGameConfiguration

object CommandLineRacingGameConfigurator {
    fun run(): RacingGameConfiguration {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val nameOfCars = readln().split(",")

        println("시도할 횟수는 몇 회인가요?")
        val numberOfTries = readln()

        return RacingGameConfiguration.of(nameOfCars, numberOfTries.toInt())
    }
}
