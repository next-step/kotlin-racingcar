package racingcar

import racingcar.domain.RacingCars
import racingcar.service.RacingCarService
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputValue = InputView.input()

    var racingCars = RacingCars.of(inputValue.drivers)

    repeat(inputValue.trials) {
        racingCars = RacingCarService.race(racingCars.list)
        ResultView.showRacingStage(racingCars.list.map { it.progress })
    }
}
