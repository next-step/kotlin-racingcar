package racingcar

import racingcar.domain.RacingCar
import racingcar.service.RacingCarService
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputValue = InputView.input()

    var cars = List(inputValue.carNumbers) { RacingCar() }

    repeat(inputValue.trials) {
        cars = RacingCarService.race(cars)
        ResultView.showRacingStage(cars.map { it.progress })
    }
}
