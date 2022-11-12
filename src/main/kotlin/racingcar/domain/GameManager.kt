package racingcar.domain

import racingcar.model.NonNegative
import racingcar.ui.InputView
import racingcar.ui.ResultView

object GameManager {

    fun racing() {
        val cars = Cars(CarNames(InputView.carNames()))
        val numberOfRaces = NonNegative(InputView.numberOfRaces()).getNonNegativeValue()
        println("\n실행 결과")
        for (race in 1..numberOfRaces) {
            cars.racing()
            ResultView.racing(cars.racingResult())
        }
    }
}
