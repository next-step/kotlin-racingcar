package racingcar.ui

import racingcar.domain.RacingCar
import racingcar.domain.RacingGame
import racingcar.domain.carracer.RandomCarRacer

class InputView {

    fun inputNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }

    fun inputRacingGame(): RacingGame {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCars = readLine()!!.toInt()

        return RacingGame((1..numberOfCars).map { RacingCar(RandomCarRacer()) })
    }
}
