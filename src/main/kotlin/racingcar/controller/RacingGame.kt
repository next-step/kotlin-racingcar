package racingcar.controller

import racingcar.domain.Cars
import racingcar.dto.ResultDto
import racingcar.dto.WinnersDto
import racingcar.infra.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame {
    private val inputView = InputView()
    private val resultView = ResultView()

    fun play() {
        val carNames = inputView.askCarNames()
        val moveNumber = inputView.askMoveNumber()
        val cars = Cars(carNames, RandomNumberGenerator())

        resultView.printResultMessage()
        repeat(moveNumber) {
            cars.move()
            resultView.printResult(ResultDto(cars.exportResult()))
        }
        resultView.printWinners(WinnersDto(cars.exportWinners()))
    }
}
