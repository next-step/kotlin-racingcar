package racingcar.domain

private const val COMMA = ","

class Cars(registerCarNames: String) {

    val cars = registerCarNames.split(COMMA).map { Car(CarName(it)) }

    fun moveOfCars(movingStrategy: MovingStrategy) {
        cars.forEach { it.moveCar(movingStrategy) }
    }

    fun winners(): List<String> {
        return Winners.winnerNames(cars)
    }
}
