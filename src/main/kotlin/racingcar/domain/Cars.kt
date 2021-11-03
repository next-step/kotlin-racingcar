package racingcar.domain

class Cars(registerCarNumber: Int) {

    val cars = registerCar(registerCarNumber)

    private fun registerCar(registerCarNumber: Int): List<Car> {
        return List(registerCarNumber) { Car() }
    }

    fun moveOfCars(movingStrategy: MovingStrategy) {
        cars.forEach { it.moveCar(movingStrategy) }
    }
}
