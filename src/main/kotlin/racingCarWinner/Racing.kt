package racingCarWinner

import racingCarWinner.domain.RacingGame
import racingCarWinner.view.InputView
import racingCarWinner.view.ResultView

class Racing private constructor(
    private val racingGame: RacingGame
) {
    fun racing() {
        ResultView.printResultText()

        repeat(racingGame.numOfAttempts) {
            val racingCars = racingGame.start()
            ResultView.printResultState(racingCars)
        }

        val winners = racingGame.selectWinner()
        ResultView.printWinners(winners)
    }

    companion object {
        fun of(racingGame: RacingGame): Racing {
            return Racing(racingGame = racingGame)
        }
    }
}

fun main() {
    val inputs = InputView.gatherUserInput()
    val racingGame = RacingGame.of(
        carNames = inputs.carNames,
        numOfAttempts = inputs.numOfAttempts
    )
    Racing.of(racingGame).racing()
}