package racingcar

import racingcar.domain.CarName
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.dto.RacingGameResponse
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val request = InputView.input()
    val inputCarNames = request.inputCarNames
    val laps = request.inputLaps

    val carNames = CarName.ofList(inputCarNames)
    val cars = Cars.of(carNames)
    val racingGame = RacingGame(cars, laps)

    while (racingGame.isNotEnd()) {
        racingGame.start()
    }

    val report = racingGame.report
    ResultView.print(RacingGameResponse.of(report))
}
