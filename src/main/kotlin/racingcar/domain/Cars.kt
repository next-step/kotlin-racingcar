package racingcar.domain

class Cars(registerCarNumber: Int) {

    val cars = List(registerCarNumber) { Car() }

    fun moveOfCars(movingStrategy: MovingStrategy) {
        cars.forEach { it.moveCar(movingStrategy) }
    }
}
