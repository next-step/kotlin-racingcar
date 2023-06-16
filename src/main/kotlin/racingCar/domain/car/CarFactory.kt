package racingCar.domain.car

object CarFactory {
    fun createCars(carNames: List<String>, engine: Engine): List<Car> {
        return carNames.map { carName -> Car(carName, engine) }
    }
}
