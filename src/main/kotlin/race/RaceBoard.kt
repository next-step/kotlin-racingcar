package race

class RaceBoard(
    private val cars: Cars,
    private val generate: RaceIterator<MoveCondition>,
) {
    fun start(): RaceResult {
        val raceRounds =
            generate.asSequence()
                .chunked(cars.size)
                .map { moveConditions ->
                    moveConditions.forEachIndexed { index, moveCondition ->
                        cars.moveAt(index, moveCondition)
                    }
                    RaceRound(cars.copy())
                }
                .toList()

        return RaceResult(raceRounds)
    }
}
