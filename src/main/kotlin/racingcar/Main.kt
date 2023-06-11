package racingcar

import racingcar.domain.RacingCar
import racingcar.service.RacingCarService
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inp = InputView.input()

    var cars = List(inp.carNumbers) { RacingCar() }

    repeat(inp.trials) {
        cars = RacingCarService.race(cars)
        ResultView.showRacingStage(cars.map { it.progress })
    }
}
