package race

class RaceBoard(
    private val cars: Cars,
    private val moveConditions: MoveConditions,
) {
    fun start(): RaceResult {
        val raceRounds =
            moveConditions.asSequence()
                .chunked(cars.size)
                .map { moveConditions ->
                    moveConditions.forEachIndexed { index, moveCondition ->
                        cars.moveAt(index, moveCondition)
                    }
                    RaceRound(
                        cars.values.map {
                            it.displayName to it.progress
                        },
                    )
                }
                .toList()

        return RaceResult(raceRounds)
    }
}
