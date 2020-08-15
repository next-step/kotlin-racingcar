package onestep.racingcar

import onestep.racingcar.domain.Racing
import onestep.racingcar.view.InputView
import onestep.racingcar.view.ResultView

fun main() {
    RacingManager(ResultView()).run {
        ready(InputView())
        race()
    }
}

class RacingManager(
    private val resultView: ResultView
) {
    private lateinit var racing: Racing

    fun ready(inputView: InputView) {
        val (carNames, tryCount) = inputView.getInputs()
        racing = Racing(carNames, tryCount)
    }

    fun race() {
        racing.race { cars ->
            resultView.showResult(cars)
        }.run {
            resultView.showWinner(this)
        }
    }
}
