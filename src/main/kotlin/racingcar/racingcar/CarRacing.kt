package racingcar.racingcar

class CarRacing(
    private val indicatorGenerator: IndicatorGenerator,
    private val turnCount: Int,
    private val cars: List<Car>
) {
    private var carRacingResult = CarRacingResult()
    private var maxDistance = 0

    fun start() {
        this.carRacingResult = CarRacingResult()
        val indicators = indicatorGenerator.generate(cars.size, turnCount)
        for (turn in 0 until turnCount) {
            val indicator = indicators[turn]

            val turnRecord = cars
                .onEachIndexed { index, car ->
                    car.go(indicator.findByCarIndex(index))
                    recordMaxDistance(car)
                }
                .map {
                    CarRecord(it, it.currentDistance())
                }
            carRacingResult.record(TurnRecord(turn + 1, turnRecord))
        }
    }

    private fun recordMaxDistance(car: Car) {
        maxDistance = maxDistance.coerceAtLeast(car.currentDistance())
    }

    fun result(): CarRacingResult {
        carRacingResult.winners = determineWinners()
        return carRacingResult
    }

    private fun determineWinners(): List<Car> {
        val finalTurnRecord = carRacingResult.records.last()
        return finalTurnRecord.results
            .filter { it.distance == maxDistance }
            .map { it.car }
    }
}
