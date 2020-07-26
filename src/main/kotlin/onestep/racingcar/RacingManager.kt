package onestep.racingcar

import onestep.racingcar.model.Racing
import onestep.racingcar.view.InputView
import onestep.racingcar.view.ResultView

fun main() {
    RacingManager(InputView(), ResultView())
        .race()
}

class RacingManager(
    inputView: InputView,
    private val resultView: ResultView
) {
    private val racing: Racing

    init {
        val (carCount, tryCount) = inputView.showInput()
        racing = Racing(carCount, tryCount)
    }

    fun race() {
        racing.race { cars ->
            resultView.showResult(cars)
        }
    }
}
