package study.domain

data class RaceResult internal constructor(private val result: MutableMap<Int, List<RaceCar>> = mutableMapOf()) {
    fun recordRound(round: Int, raceCars: List<RaceCar>) {
        result[round] = raceCars
    }

    fun getRounds() = result.keys.toList()

    fun getCarPositions(round: Int) = result[round]?.map { it.getPosition() }

    companion object {
        fun empty(): RaceResult {
            return RaceResult()
        }
    }
}
