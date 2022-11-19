package racingcar

class CarFactory {
    fun create(numberOfCars: Int): List<Car> =
        List(numberOfCars) { Car() }
}
