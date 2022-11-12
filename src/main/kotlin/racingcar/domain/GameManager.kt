package racingcar.domain

import racingcar.model.NonNegative
import racingcar.ui.InputView
import racingcar.ui.ResultView

object GameManager {

    fun run() {
        val cars = Cars(CarNames(InputView.carNames()))
        racing(cars)
        winners(cars)
    }

    private fun racing(cars: Cars) {
        val numberOfRaces = NonNegative(InputView.numberOfRaces()).getNonNegativeValue()
        println("\n실행 결과")
        for (race in 1..numberOfRaces) {
            cars.racing()
            ResultView.racing(cars.racingResult())
        }
    }

    private fun winners(cars: Cars) {
        ResultView.winners(cars.winners())
    }
}
