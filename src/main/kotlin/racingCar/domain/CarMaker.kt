package racingCar.domain

object CarMaker {
    fun createCars(carNames: List<String>, carMover: CarMovable): List<Car> {
        return carNames.map { Car(carMover, it) }
    }
}