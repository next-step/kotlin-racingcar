package step4.racingcar.racingcar

object CarRacing {
    fun execute(racers: List<String>, moveCount: Int): List<Car> {
        val car = racers.map { Car(it, CarEngine()) }
        repeat(moveCount) {
            executeCarMove(car)
        }
        return car
    }

    private fun executeCarMove(carList: List<Car>) {
        carList.forEach {
            it.move()
        }
    }
}
