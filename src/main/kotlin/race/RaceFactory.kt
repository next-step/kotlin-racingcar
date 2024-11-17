package race

object RaceFactory {
    fun createRaceBoard(
        cars: Cars,
        roundSize: PositiveNumber,
    ): RaceBoard {
        val moveConditions = MoveConditions(cars.size * roundSize.value, RandomGenerate().generate)
        return RaceBoard(cars, moveConditions)
    }
}
