package raicing.model

data class RaceResult(
    val raceCars: List<RaceCar>
) {
    fun whoIsWinner(): List<Car> {
        val raceLastResult = raceCars.lastOrNull() ?: return emptyList()
        val maxPosition = raceLastResult.getMaxPosition()

        if (maxPosition == 0) {
            return emptyList()
        }

        return raceLastResult.getCarsByPosition(maxPosition)
    }
}
