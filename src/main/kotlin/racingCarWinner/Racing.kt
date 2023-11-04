package racingCarWinner

import racingCarWinner.domain.RacingGame
import racingCarWinner.view.InputView
import racingCarWinner.view.ResultView

class Racing private constructor(
    private val racingGame: RacingGame
) {
    fun start(numOfAttempts: Int): List<String> {
        ResultView.printResultText()

        repeat(numOfAttempts) {
            val racingCars = racingGame.racing()
            ResultView.printResultState(racingCars)
        }

        val winners = racingGame.selectWinner()
        ResultView.printWinners(winners)
        return winners
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
        carNames = inputs.carNames
    )
    Racing.of(racingGame).start(inputs.numOfAttempts)
}