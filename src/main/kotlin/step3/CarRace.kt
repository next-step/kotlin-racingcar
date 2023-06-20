package step3

import step3.view.DisplayView
import step3.view.InputView

class CarRace(
    private val carMover: CarMover
) {
    private val numOfCar: Int = InputView.inputNumOfCar()
    private val numOfMove: Int = InputView.inputNumOfGame()
    private val carList: List<Car> = List(numOfCar) { Car(carMover) }

    fun race() {
        DisplayView.displayHeader()
        repeat(numOfMove) {
            carMover.move(carList)
            DisplayView.displayRaceProgress(carList)
        }
    }
}