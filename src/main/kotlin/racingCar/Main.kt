package racingCar

import racingCar.domain.CarMaker
import racingCar.domain.CarRace
import racingCar.domain.RandomCarMovable
import racingCar.view.DisplayView
import racingCar.view.InputView

fun main() {
    val carNames = InputView.inputNameOfCar()
    val numOfGame = InputView.inputNumOfGame()

    val cars = CarMaker.createCars(carNames, RandomCarMovable())

    DisplayView.displayHeader()
    val raceResult = CarRace.start(cars, numOfGame)
    DisplayView.displayRaceResult(raceResult)
}