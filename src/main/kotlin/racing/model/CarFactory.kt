package racing.model

object CarFactory {
    fun createCars(
        carNames: List<String>,
        range: IntRange = IntRangeEngine.DEFAULT_RANDOM_RANGE,
        forwardLimit: Int = Car.DEFAULT_FORWARD_LIMIT
    ): RacingCars {
        val carList = carNames.map {
            val engine = IntRangeEngineFactory.create(range, forwardLimit)
            Car(it, engine)
        }
        return RacingCars(carList)
    }
}
