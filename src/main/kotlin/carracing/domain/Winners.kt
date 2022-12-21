package carracing.domain

class Winners(private val cars: Cars) {

    fun getWinners(): String {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.getName() }

        return winners.joinToString(WINNER_DELIMITER)
    }

    companion object {
        private const val WINNER_DELIMITER = ","
    }
}
