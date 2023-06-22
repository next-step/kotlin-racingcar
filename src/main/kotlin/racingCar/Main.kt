package racingCar

import racingCar.domain.CarMaker
import racingCar.domain.CarRace
import racingCar.domain.RandomCarMovable
import racingCar.view.DisplayView
import racingCar.view.InputView

fun main() {
    val input = InputView()

    val carNames = input.inputNameOfCar()
    val carMaker = CarMaker(carNames, RandomCarMovable())
    val carRace = CarRace(carMaker.createCars(), input.inputNumOfGame())

    DisplayView.displayHeader()
    val raceResult = carRace.start()
    DisplayView.displayRaceResult(raceResult)
}