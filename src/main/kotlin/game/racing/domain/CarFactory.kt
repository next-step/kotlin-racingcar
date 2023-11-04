package game.racing.domain

object CarFactory {
    fun generateCarByNumberOfCar(numberOfCar: Int): List<Car> {
        return List(numberOfCar) { Car() }
    }
}
