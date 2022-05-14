package racingcar

import racingcar.domain.CarName
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.dto.RacingGameRecordResponse
import racingcar.dto.RacingGameWinnerResponse
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val request = InputView.input()
    val carNames = request.inputCarNames
    val laps = request.inputLaps

    val cars = Cars.of(CarName.ofList(carNames))
    val racingGame = RacingGame(cars, laps)

    while (racingGame.isNotEnd()) {
        racingGame.start()
    }

    val record = racingGame.record

    ResultView.printResult()
    ResultView.printRecord(RacingGameRecordResponse.of(record.lapRecords))
    ResultView.printWinner(RacingGameWinnerResponse.of(record.winner()))
}
