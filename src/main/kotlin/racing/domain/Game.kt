package racing.domain

class Game(
    val cars: List<Car>,
    private val round: Int = 3,
) {
    fun play(printRaceStatus: (List<Car>) -> Unit): GameResult {
        for (i in 0 until round) {
            race()
            printRaceStatus(cars)
        }
        return GameResult(cars)
    }

    private fun race() {
        cars.forEach {
            it.move()
        }
    }
}
