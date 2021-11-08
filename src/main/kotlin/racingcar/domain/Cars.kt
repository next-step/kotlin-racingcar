package racingcar.domain

class Cars(registerCarName: String) {

    val cars = registerCarName.split(COMMA).map { Car(CarName(it)) }

    fun moveOfCars(movingStrategy: MovingStrategy) {
        cars.forEach { it.moveCar(movingStrategy) }
    }

    companion object {
        private const val COMMA = ","
    }
}
