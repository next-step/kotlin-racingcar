package step3.domain.race

data class RaceResult(val roundResultList: List<RaceRoundResult>) {

    fun getRoundCount(): Int = roundResultList.size

    fun getRoundResult(roundIndex: Int): RaceRoundResult {
        require(roundIndex >= 0 && roundIndex < getRoundCount())
        return roundResultList[roundIndex]
    }
}
