package racingame.domain

class Winner(
    private val cars: Cars
) {
    val winnerNames: List<String>
        get() = findWinners()

    private fun findWinners(): List<String> {
        val maxPosition = cars.values.maxOf { it.position }

        return cars.values.filter { it.position == maxPosition }
            .map { it.name }
    }
}
