package racing.domain

interface CarRacingRecordStrategy {
    fun recordRacingResultPerRound(cars: List<Car>): List<Car>

    fun findWinners(cars: List<Car>): List<String>
}
