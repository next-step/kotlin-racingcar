package racingcar.racingcar

class CarRacing(
    private val indicatorGenerator: IndicatorGenerator,
    private val turnCount: Int,
    private val cars: List<Car>
) {
    private var carRacingResult = CarRacingResult()

    fun start() {
        this.carRacingResult = CarRacingResult()
        val indicators = indicatorGenerator.generate(cars.size, turnCount)
        for (turn in 0 until turnCount) {
            val indicator = indicators[turn]

            val turnRecord = cars.mapIndexed { index, car ->
                car.go(indicator.findByCarIndex(index))
                car.currentLocation()
            }
            carRacingResult.record(TurnRecord(turn + 1, turnRecord))
        }
    }

    fun result(): CarRacingResult {
        return carRacingResult
    }
}
