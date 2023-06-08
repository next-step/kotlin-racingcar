package racingcar.controller

import racingcar.domain.RacingCar
import racingcar.domain.RacingCarGame
import racingcar.ui.enterCountOfCars
import racingcar.ui.enterNumberOfAttempts
import racingcar.ui.printPosition
import racingcar.ui.printStart

class RacingCarController {

    fun start() {
        val countOfCars = enterCountOfCars()
        val numberOfAttempts = enterNumberOfAttempts()

        val racingCarGame = RacingCarGame(createRacingCars(countOfCars), numberOfAttempts)

        printStart()

        while (racingCarGame.racingAttemptsCheck()) {
            racingCarGame.racing()
            printPosition(racingCarGame.racingCars)
        }
    }

    private fun createRacingCars(racingCarCounts: Int): List<RacingCar> {
        val racingCars = mutableListOf<RacingCar>()
        repeat((1..racingCarCounts).count()) {
            racingCars.add(RacingCar())
        }
        return racingCars
    }
}
