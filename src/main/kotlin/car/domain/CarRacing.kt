package car.domain

object CarRacing {
    fun race(cars: Cars): List<Position> {
        return cars.move(RandomMovingStrategy())
    }
}
