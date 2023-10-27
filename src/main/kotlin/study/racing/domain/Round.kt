package study.racing.domain

class Round(
    private val roundCount: Int
) {

    init {
        require(roundCount > 0) {
            "레이싱 횟수는 최소 1회 이상 요청해 주세요."
        }
    }

    fun getRoundCount(): Int {
        return this.roundCount
    }
}
