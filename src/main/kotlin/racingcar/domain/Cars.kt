package racingcar.domain

class Cars(registerCarNames: String) {

    val cars = registerCarNames.split(COMMA).map { Car(CarName(it)) }

    fun moveOfCars(movingStrategy: MovingStrategy) {
        cars.forEach { it.moveCar(movingStrategy) }
    }

    fun winners(): List<Car> {
        return Winners.winnerNames(cars)
    }

    companion object {
        private const val COMMA = ","
    }
}
