package racing.domain

class Result {
    private val roundResults: MutableList<CarInfos> = mutableListOf()
    val carInfosList: List<CarInfos>
        get() = roundResults.toList()

    val winners: Winners
        get() {
            val lastRoundResult = roundResults[roundResults.size - 1]
            return Winners(lastRoundResult)
        }

    fun add(carInfos: CarInfos) {
        roundResults.add(carInfos)
    }
}
