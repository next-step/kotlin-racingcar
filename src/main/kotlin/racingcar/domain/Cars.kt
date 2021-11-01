package racingcar.domain

class Cars(registerCarNumber: Int) {

    val cars: List<Car>

    init {
        cars = registerCar(registerCarNumber)
    }

    private fun registerCar(registerCarNumber: Int): List<Car> {
        return (REGISTER_CAR_START_NUMBER..registerCarNumber).map { Car() }
    }

    fun moveOfCars(carMovingStrategy: Boolean) {
        cars.forEach { it.moveCar(carMovingStrategy) }
    }

    companion object {
        private const val REGISTER_CAR_START_NUMBER = 1
    }
}
