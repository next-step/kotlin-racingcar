package racing.domain

object CarRacingRecorder : CarRacingRecordStrategy {
    override fun recordRacingResultPerRound(cars: List<Car>): List<Car> = cars.map {
        // TODO copy 대신 다른 방법 찾아보기
        Car.of(it.name, it.position)
    }

    override fun findWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxBy { it.position }
            .position
        return cars.filter { car -> car.position == maxPosition }
            .map { it.name }
    }
}
