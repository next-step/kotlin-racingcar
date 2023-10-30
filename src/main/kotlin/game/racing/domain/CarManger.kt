package game.racing.domain

class CarManger {
    val cars = mutableListOf<Car>()

    fun generateCarByNumberOfCar(numberOfCar: Int) {
        resetCars()
        repeat(numberOfCar) {
            cars.add(Car())
        }
    }

    private fun resetCars() {
        cars.clear()
    }

    fun moveCars() {
        cars.forEach {
            it.move()
        }
    }
}
