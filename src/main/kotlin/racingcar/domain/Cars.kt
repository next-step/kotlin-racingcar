package racingcar.domain

class Cars(registerCarName: String) {

    val cars = registerCarName.split(COMMA).map { Car(CarName(it)) }

    fun moveOfCars(movingStrategy: MovingStrategy) {
        cars.forEach { it.moveCar(movingStrategy) }
    }

    fun winners(): String {
        return Winners.winnerNames(cars)
    }

    companion object {
        private const val COMMA = ","
    }
}
