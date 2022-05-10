package racingcar

import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.dto.RacingGameResponse
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val request = InputView.input()
    val carCount = request.inputCarCount
    val laps = request.inputLaps

    val cars = Cars.of(carCount)
    val racingGame = RacingGame(cars, laps)

    while (racingGame.isNotEnd()) {
        racingGame.start()
    }

    val lapReports = racingGame.lapReports
    ResultView.print(RacingGameResponse(lapReports))
}
