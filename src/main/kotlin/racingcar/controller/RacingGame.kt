package racingcar.controller

import racingcar.domain.Cars
import racingcar.dto.ResultDto
import racingcar.infra.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame {
    private val inputView = InputView()
    private val resultView = ResultView()

    fun play() {
        val carNumber = inputView.askCarNumber()
        val moveNumber = inputView.askMoveNumber()
        val cars = Cars(carNumber, RandomNumberGenerator())

        resultView.printResultMessage()
        repeat(moveNumber) {
            cars.move()
            resultView.print(ResultDto(cars.exportPositions()))
        }
    }
}
