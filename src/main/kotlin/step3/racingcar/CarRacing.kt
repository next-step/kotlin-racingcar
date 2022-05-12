package step3.racingcar

object CarRacing {
    fun execute(carCount: Int, moveCount: Int): List<Car> {
        return List(carCount) { Car.withMovements(moveCount) }
    }
}
