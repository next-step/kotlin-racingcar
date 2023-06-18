package step3

import step3.view.DisplayView
import step3.view.InputView

class CarRace {
    private val carList: List<Car>
    private val carMover: CarMover = CarMover()
    private val numOfCar: Int = InputView.inputNumOfCar()
    private val numOfMove: Int = InputView.inputNumOfGame()

    init {
        carList = List(numOfCar) { Car() }
    }

    fun race() {
        DisplayView.displayHeader()
        repeat(numOfMove) {
            carMover.move(carList)
            DisplayView.displayRaceProgress(carList)
        }
    }
}