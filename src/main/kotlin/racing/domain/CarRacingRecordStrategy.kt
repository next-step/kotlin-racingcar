package racing.domain

interface CarRacingRecordStrategy {
    fun recordRacingResultPerRound(cars: List<Car>): List<CarRacingRecord>

    fun findWinners(cars: List<Car>): List<String>
}
