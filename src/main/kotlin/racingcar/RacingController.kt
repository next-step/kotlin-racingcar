package racingcar

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingController {

    fun race() {
        val carNames: List<String> = this.getCarNames()
        val playCount: Int = this.getPlayCount()
        this.playGame(carNames, playCount)
    }

    private fun getCarNames(): List<String> {
        ResultView.printMessage(ResultView.Message.CAR_NAMES_WITH_COMMA)
        return InputView.requestString(DELIMITERS)
    }

    private fun getPlayCount(): Int {
        ResultView.printMessage(ResultView.Message.PLAY_COUNT)
        return InputView.requestPositiveNumber()
    }

    private fun playGame(carNames: List<String>, playCount: Int) {
        ResultView.printMessage(ResultView.Message.RESULT)
        val racingGame = RacingGame(RandomForward(), carNames)
        val winners: List<String> = racingGame.play(playCount, printResult)

        ResultView.printMessage(winners.joinToString(DELIMITERS), ResultView.Message.WINNER)
    }

    companion object {
        private const val DELIMITERS = ","

        private val printResult: (List<Car>) -> Unit = { cars ->
            cars.forEach { car ->
                ResultView.printResult(name = car.name, distance = car.position)
            }

            ResultView.printNewLine()
        }
    }
}

fun main() {
    RacingController().race()
}
