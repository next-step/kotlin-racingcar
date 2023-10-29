package game

class UserMessageDisplay : UserOutputHandler {

    override fun display(cars: List<Car>) {
        cars.forEach(::display)
        println()
    }

    private fun display(car: Car) = println(
        buildString {
            append(car.name)
            append(DELIMITER)
            append(POSITION_MARKER.repeat(car.position))
        }
    )

    override fun displayWinners(winners: List<String>) {
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }

    companion object {
        private const val POSITION_MARKER = "-"
        private const val DELIMITER = " : "
    }
}
