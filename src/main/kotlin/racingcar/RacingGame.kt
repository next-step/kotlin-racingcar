package racingcar

class RacingGame(
    val gameCount: Int,
    val cars: List<Car> = listOf()
) {
    fun start() {
        OutputView().printResult()
        repeat(gameCount) {
            moveCars()
            println()
        }
    }

    private fun moveCars() {
        cars.forEach { car ->
            car.move()
            println(OutputView().printPosition(car.position))
        }
    }
}
