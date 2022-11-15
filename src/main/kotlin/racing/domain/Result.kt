package racing.domain

class Result(val roundResults: List<CarInfos>) {

    val winners: Winners
        get() {
            val lastRoundResult = roundResults[roundResults.size - 1]
            return Winners(lastRoundResult)
        }
}
