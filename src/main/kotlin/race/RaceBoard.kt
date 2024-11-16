package race

class RaceBoard(
    private val cars: Cars,
    private val retryCount: Int,
    private val numberGenerate: NumberGenerator,
) {
    fun start(): RaceResult {
        return RaceResult(
            (1..retryCount).map {
                val moveConditions = MoveConditions(cars.size) { numberGenerate() }

                cars.moveAll(moveConditions)
                RaceRound(cars.map { it })
            },
        )
    }
}
