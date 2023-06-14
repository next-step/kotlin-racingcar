package step3.domain.race

data class RaceResult(val roundResults: List<RaceRoundResult>) {

    val roundCount: Int = roundResults.size

    fun getRoundResult(roundIndex: Int): RaceRoundResult {
        require(roundIndex in 0 until roundCount) { " 유효하지 않은 round 번호 입니다" }
        return roundResults[roundIndex]
    }
}
