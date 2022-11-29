package step3.racingcar.domain

class RoundResults private constructor(val totalRound: Int, val cars: Cars) {
    private val elements: MutableList<RoundResult> = mutableListOf()

    operator fun get(index: Int) = elements[index]
    fun add(roundResult: RoundResult) = elements.add(roundResult)

    companion object {
        fun of(playInfo: PlayInfo): RoundResults = RoundResults(playInfo.totalRound, playInfo.cars)
    }
}
