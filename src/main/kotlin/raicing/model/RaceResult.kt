package raicing.model

data class RaceResult(
    val raceCars: List<RaceCar>
) {
    fun whoIsWinner(): List<Car> {
        val raceLastResult = raceCars.lastOrNull()
        return raceLastResult?.getMaxPosition()?.let { maxPosition ->
            if (maxPosition == 0) {
                emptyList()
            } else {
                raceLastResult.getMaxPositionCars(maxPosition)
            }
        } ?: emptyList()
    }
}
