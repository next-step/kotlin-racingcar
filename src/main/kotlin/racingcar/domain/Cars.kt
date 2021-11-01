package racingcar.domain

class Cars(registerCarNumber: Int) {

    val cars = registerCar(registerCarNumber)

    private fun registerCar(registerCarNumber: Int): List<Car> {
        return List(registerCarNumber) { Car() }
    }

    fun moveOfCars(carMovingStrategy: Boolean) {
        cars.forEach { it.moveCar(carMovingStrategy) }
    }
}
