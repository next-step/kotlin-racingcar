package car

import car.application.CarRacing
import car.application.dto.RacingInput
import car.application.vo.TryCount
import car.ui.InputView
import car.ui.OutputView

fun main() {
    val (carNames, tryCount) = InputView.input()
    val racingResult = CarRacing.race(RacingInput(carNames, TryCount(tryCount)))
    OutputView.output(racingResult)
}
