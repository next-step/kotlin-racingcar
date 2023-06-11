package racingcar.controller

import racingcar.domain.RacingCar
import racingcar.domain.RacingCarGame
import racingcar.ui.enterCarNames
import racingcar.ui.enterNumberOfAttempts
import racingcar.ui.printPosition
import racingcar.ui.printStart
import racingcar.ui.printWinner

class RacingCarController {

    fun start() {
        val carNames = enterCarNames().trim()
        val numberOfAttempts = enterNumberOfAttempts()

        val racingCarGame = RacingCarGame(createRacingCars(carNames), numberOfAttempts)

        printStart()

        while (racingCarGame.racingAttemptsCheck()) {
            racingCarGame.racing()
            printPosition(racingCarGame.racingCars)
        }

        printWinner(racingCarGame.winners())
    }

    private fun createRacingCars(racingCarNames: String): List<RacingCar> {
        val racingCars = mutableListOf<RacingCar>()
        val carNameSplit = racingCarNames.split(CAR_NAME_SPLIT_SYMBOL)
        carNameSplit.mapTo(racingCars) { RacingCar(it) }
        return racingCars
    }

    companion object {
        const val CAR_NAME_SPLIT_SYMBOL = ","
    }
}
