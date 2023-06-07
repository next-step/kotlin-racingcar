package race

data class RaceResult(
    val positions: List<CarPositions>,
) {
    fun latestPosition() = positions.last()

    fun appendPositions(carPositions: CarPositions) = copy(positions = positions.plus(carPositions))

    companion object {
        fun getInitialRaceResult(startInformation: RaceStartInformation): RaceResult {
            return (0 until startInformation.numberOfCars).map {
                CarPosition(1)
            }.let {
                RaceResult(listOf(CarPositions(it)))
            }
        }
    }
}
