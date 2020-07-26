package onestep.racingcar

import onestep.racingcar.model.Car
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
    private var racing: Racing

    init {
        val pair = inputView.showInput()
        racing = Racing(pair.first, pair.second)
    }

    fun race() {
        racing.ready()
        racing.race { cars ->
            resultView.showResult(cars.map(Car::printPosition))
        }
    }
}
