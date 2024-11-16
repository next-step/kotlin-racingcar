package race

object RaceFactory {
    fun createRaceBoard(
        cars: Cars,
        roundSize: PositiveNumber,
    ): RaceBoard {
        val iterator = RandomMoveConditionIterator(cars.size * roundSize.value, RandomGenerate())
        return RaceBoard(cars, iterator)
    }
}
