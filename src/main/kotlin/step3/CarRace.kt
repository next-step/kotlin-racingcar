package step3

import step3.domain.Car
import step3.domain.CarMover
import step3.domain.RandomCarMover
import step3.view.DisplayView
import step3.view.InputView

class CarRace(
    private val carMover: CarMover,
    private val input: InputView
) {
    private val carNames: List<String> = input.inputNameOfCar()
    private val numOfMove: Int = input.inputNumOfGame()
    private val carList: List<Car> = createCars(carNames)

    fun race() {
        DisplayView.displayHeader()
        repeat(numOfMove) {
            carMover.move(carList)
            DisplayView.displayRaceProgress(carList)
        }
        val winners = getWinners(carList)
        DisplayView.displayRaceResult(winners)
    }

    private fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(carMover, it) }
    }

    private fun getWinners(carList: List<Car>): List<Car> {
        val maxPosition = carList.maxOf { car -> car.position }
        return carList.filter{ it.position == maxPosition }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val carRace = CarRace(RandomCarMover(), InputView())
            carRace.race()
        }
    }
}