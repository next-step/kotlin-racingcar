package carracing.domain

const val WINNER_DELIMITER = ","

class Winners(private val cars: Cars) {

    fun getWinners(): String {
        val maxPosition = cars.maxOf { it.position }

        val winners = cars.filter { it.position == maxPosition }

        return winners.joinToString(WINNER_DELIMITER) { it.name }
    }
}
