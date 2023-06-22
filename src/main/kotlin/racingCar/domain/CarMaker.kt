package racingCar.domain

class CarMaker(
    private val carNames: List<String>,
    private val carMover: CarMovable
) {
    fun createCars(): List<Car> {
        return carNames.map { Car(carMover, it) }
    }
}