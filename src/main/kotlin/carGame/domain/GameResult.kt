package carGame.domain

class GameResult(
    val history: List<Cars>
) {
    fun getWinners(): List<Car> {
        val maxPosition = getLatestCars().maxBy { it.position }.position
        return getLatestCars()
            .filter { it.position == maxPosition }
    }

    private fun getLatestCars(): List<Car> {
        return history.last().cars
    }
}
