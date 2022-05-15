package step3.racingcar

object CarRacing {
    fun execute(carCount: Int, moveCount: Int): List<Car> {
        val car = List(carCount) { Car(CarEngine()) }
        repeat(moveCount) {
            car.forEach {
                it.move()
            }
        }
        return car
    }
}
