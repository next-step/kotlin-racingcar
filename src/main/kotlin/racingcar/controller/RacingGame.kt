package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.GameInputValue
import racingcar.domain.InputName
import racingcar.domain.InputNumber
import racingcar.domain.RandomMovingStrategy
import racingcar.domain.WinnerSelector
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame {
    private val inputNameOfCars = InputName(InputView().getNameOfCars()).names
    private val inputNumberOfTGames = InputNumber(InputView().getNumberOfGames()).number
    private val gameInputValue = GameInputValue(inputNameOfCars, inputNumberOfTGames)
    private val cars = Cars(inputNameOfCars, RandomMovingStrategy())
    private val outputView = OutputView()

    fun start() {
        cars.race(gameInputValue) { position -> onPositionStateCallback(position) }
        outputView.showWinner(WinnerSelector(cars.getRacingCars()).selectWinner())
    }

    private fun isLastCarCycle(numberOfCar: Int, nameOfCarsSize: Int): Boolean {
        return numberOfCar == nameOfCarsSize - 1
    }

    private fun onPositionStateCallback(position: Int) {
        outputView.showRaceState(
            cars.getRacingCars()[position].getCar().name,
            cars.getRacingCars()[position].getCar().position,
            isLastCarCycle(position, inputNameOfCars.size)
        )
    }
}
