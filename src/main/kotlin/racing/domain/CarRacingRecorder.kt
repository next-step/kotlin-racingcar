package racing.domain

object CarRacingRecorder : CarRacingRecordStrategy {
    override fun recordRacingResultPerRound(cars: List<Car>): List<CarRacingRecord> = cars.map { car ->
        CarRacingRecord(car.name, car.position)
    }

    override fun findWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxBy { it.position }
            .position
        return cars.filter { car -> car.position == maxPosition }
            .map { it.name }
    }
}
