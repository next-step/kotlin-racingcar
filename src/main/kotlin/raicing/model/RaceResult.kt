package raicing.model

data class RaceResult(
    val raceCars: List<RaceCar>
) {
    fun whoIsWinner(): List<Car>? {
        val raceResult = raceCars.lastOrNull()
        val maxPosition = raceResult?.getCars()?.maxOf { it.position }
        return raceResult?.getCars()?.filter { it.position == maxPosition }
    }
}
