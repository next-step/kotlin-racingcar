package game.racing.domain

object CarFactory {
    fun generateCarByNumberOfCar(numberOfCar: Int): List<Car> {
        val cars = mutableListOf<Car>()
        repeat(numberOfCar) {
            cars.add(Car())
        }
        return cars
    }
}
