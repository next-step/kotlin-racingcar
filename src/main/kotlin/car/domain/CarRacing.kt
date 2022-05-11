package car.domain

object CarRacing {
    fun race(cars: Cars): List<Position> = cars.move(RandomMovingStrategy())
}
