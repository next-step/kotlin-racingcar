package study.racinggame.ui

import study.racinggame.domain.RacingGameConfiguration

interface RacingGameConfigurator {
    fun run(): RacingGameConfiguration
}

class CommandLineRacingGameConfigurator : RacingGameConfigurator {
    override fun run(): RacingGameConfiguration {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCars = readln()

        println("시도할 횟수는 몇 회인가요?")
        val numberOfTries = readln()

        return RacingGameConfiguration.of(numberOfCars.toInt(), numberOfTries.toInt())
    }
}
