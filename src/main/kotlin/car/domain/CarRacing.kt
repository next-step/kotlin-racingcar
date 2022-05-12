package car.domain

object CarRacing {
    private val movingStrategy = RandomMovingStrategy()

    fun race(cars: Cars): List<Position> = cars.move(movingStrategy)
}
