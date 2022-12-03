package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.InputName
import racingcar.domain.InputNumber
import racingcar.domain.RandomMovingStrategy
import racingcar.domain.WinnerSelector
import racingcar.dto.WinnerDto
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame {
    private val outputView = OutputView()

    fun start() {
        val inputNameOfCars = InputName(InputView().getNameOfCars()).names
        val inputNumberOfGames = InputNumber(InputView().getNumberOfGames()).number
        val cars = Cars(inputNameOfCars, RandomMovingStrategy())
        cars.race(inputNumberOfGames) { car -> onPositionStateCallback(car, inputNameOfCars.size) }
        outputView.showWinner(WinnerSelector(cars.getRacingCars()).selectWinnerName())
    }

    private fun onPositionStateCallback(winnerDto: WinnerDto, numberOfCars: Int) {
        outputView.showRaceState(
            winnerDto.name,
            winnerDto.position,
            numberOfCars
        )
    }
}
