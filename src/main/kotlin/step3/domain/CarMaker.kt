package step3.domain

import step3.view.InputView

class CarMaker(
    private val input: InputView,
    private val carMover: CarMovable
) {
    private val carNames: List<String> = input.inputNameOfCar()

    fun createCars(): List<Car> {
        return carNames.map { Car(carMover, it) }
    }
}