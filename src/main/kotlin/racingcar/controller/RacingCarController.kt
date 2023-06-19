package racingcar.controller

import racingcar.domain.NumberGenerator
import racingcar.domain.RacingCarGame.Companion.from
import racingcar.ui.enterCarNames
import racingcar.ui.enterNumberOfAttempts
import racingcar.ui.printPosition
import racingcar.ui.printStart
import racingcar.ui.printWinner
import kotlin.random.Random

class RacingCarController {

    fun start() {
        val carNames = enterCarNames().trim()
        val numberOfAttempts = enterNumberOfAttempts()
        val numberGenerator = NumberGenerator { Random.nextInt(0, 10) }

        val racingCarGame = from(carNames)

        printStart()

        repeat((1..numberOfAttempts).count()) {
            racingCarGame.racing(numberGenerator)
            printPosition(racingCarGame.racingCars)
        }

        printWinner(racingCarGame.winners())
    }

    companion object {
        const val CAR_NAME_SPLIT_SYMBOL = ","
    }
}
