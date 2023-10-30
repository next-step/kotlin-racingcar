package racing

class CarRacingRecorder {
    fun recordRacingResultPerRound(cars: List<Car>): List<Car> = cars.map { it.copy() }

    fun findWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxBy { it.position }
            .position
        return cars.filter { car -> car.position == maxPosition }
            .map { it.name }
    }
}
