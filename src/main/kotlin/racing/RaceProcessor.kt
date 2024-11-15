package racing

class RaceProcessor(
    private val carFactory: CarFactory,
    private val countGenerator: CountGenerator,
) {
    fun execute(
        carQuantity: Int,
        round: Int,
    ): RaceResult {
        validate(carQuantity, round)
        val cars = CarFactory.createCars(carQuantity)

        val result = start(cars, round)

        return result
    }

    private fun start(
        cars: List<Car>,
        round: Int,
    ): RaceResult {
        val raceResult = RaceResult()

        repeat(round) { currentRound -> processRaceIteration(cars, currentRound, raceResult) }

        return raceResult
    }

    private fun processRaceIteration(
        cars: List<Car>,
        round: Int,
        raceResult: RaceResult,
    ) {
        cars.forEach { car ->
            car.move(countGenerator.generate())
            val result =
                Result.from(
                    round = round,
                    car = car,
                )
            raceResult.add(result)
        }
    }

    private fun validate(
        carQuantity: Int,
        round: Int,
    ) {
        require(carQuantity > 0) { "차는 1대 이상이어야 합니다." }
        require(round > 0) { "라운드는 1 이상이어야 합니다." }
    }
}
