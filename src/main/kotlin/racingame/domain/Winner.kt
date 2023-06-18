package racingame.domain

class Winner(
    private val cars: List<Car>
) {
    val nameOfWinners: List<String>
        get() = findWinners()

    private fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }

        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }
}
