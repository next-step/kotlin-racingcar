package racingcar

class RacingGame(
    val gameCount: Int,
    val cars: List<Car> = listOf()
) {
    fun start() {
        repeat(gameCount) {
            moveCars()
        }
    }

    private fun moveCars() {
        cars.forEach { car ->
            car.move()
        }
    }
}
