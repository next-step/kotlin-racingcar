package step3.racing.domain

object Referee {
    fun findWinnerNames(racers: List<Car>): List<String> {
        val topDistance = findTopDistance(racers)
        return racers.filter {
            topDistance == it.distance
        }.map { it.name }
    }

    private fun findTopDistance(racers: List<Car>) = racers.maxOf { it.distance }
}
