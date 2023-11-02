package study.domain

class RaceResult internal constructor(
    winners: List<RaceCar> = listOf(),
    private val result: MutableMap<Int, List<RaceCar>> = mutableMapOf()
) {
    var winners: List<RaceCar> = winners
        private set

    fun recordRound(round: Int, raceCars: List<RaceCar>) {
        result[round] = raceCars
    }

    fun getResult() = result.toMap()

    fun recordWinners(winners: List<RaceCar>) {
        this.winners = winners
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RaceResult

        if (result != other.result) return false
        if (winners != other.winners) return false

        return true
    }

    override fun hashCode(): Int {
        var result1 = result.hashCode()
        result1 = 31 * result1 + winners.hashCode()
        return result1
    }

    companion object {
        fun empty(): RaceResult {
            return RaceResult()
        }
    }
}
