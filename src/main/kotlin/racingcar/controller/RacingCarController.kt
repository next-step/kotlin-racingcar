package racingcar.controller

import racingcar.domain.RacingCarGame.Companion.from
import racingcar.ui.enterCarNames
import racingcar.ui.enterNumberOfAttempts
import racingcar.ui.printPosition
import racingcar.ui.printStart
import racingcar.ui.printWinner

class RacingCarController {

    fun start() {
        val carNames = enterCarNames().trim()
        val numberOfAttempts = enterNumberOfAttempts()
        val racingCarGame = from(carNames)

        printStart()

        repeat(numberOfAttempts) {
            racingCarGame.racing()
            printPosition(racingCarGame.racingCars)
        }

        printWinner(racingCarGame.winners())
    }

    companion object {
        const val CAR_NAME_SPLIT_SYMBOL = ","
    }
}
