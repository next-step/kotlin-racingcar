package racing_car.domain.race

data class RaceResult(val roundResults: List<RaceRoundResult>) {
    val roundCount: Int = roundResults.size
}
