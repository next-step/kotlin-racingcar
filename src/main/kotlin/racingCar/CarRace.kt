package racingCar

import racingCar.domain.Car
import racingCar.domain.CarMaker
import racingCar.domain.RandomCarMovable
import racingCar.view.DisplayView
import racingCar.view.InputView

class CarRace(
    private val carList: List<Car>,
    private val numOfMove: Int
) {

    fun race() {
        DisplayView.displayHeader()
        repeat(numOfMove) {
            carList.forEach { it.move() }
            DisplayView.displayRaceProgress(carList)
        }
        val winners = getWinners(carList)
        DisplayView.displayRaceResult(winners)
    }

    private fun getWinners(carList: List<Car>): List<Car> {
        val maxPosition = carList.maxOf { car -> car.position }
        return carList.filter{ it.position == maxPosition }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val input = InputView()

            val carNames = input.inputNameOfCar()
            val carMaker = CarMaker(carNames, RandomCarMovable())
            val carRace = CarRace(carMaker.createCars(), input.inputNumOfGame())
            carRace.race()
        }
    }
}