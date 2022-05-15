package raicing.model

data class RaceResult(
    val raceCars: List<RaceCar>
) {
    fun whoIsWinner(): List<Car> {
        val raceResult = raceCars.last()
        val maxPosition = raceResult.getCars().maxOf { it.position }
        return raceResult.getCars().filter { it.position == maxPosition }
    }
}
