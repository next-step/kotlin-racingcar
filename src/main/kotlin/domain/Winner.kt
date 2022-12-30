package domain

class Winner(
    private val cars: List<Car>
) {
    fun getWinner(): String {
        val firstRecord = cars.maxOf { it.distance }
        val winners = cars.filter { firstRecord == it.distance }.map { it.name }
        return winners.joinToString { "," }
    }
}