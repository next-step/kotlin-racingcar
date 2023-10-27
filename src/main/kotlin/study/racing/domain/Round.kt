package study.racing.domain

class Round(
    roundCount: Int = 1
) {
    var roundCount = roundCount
        private set

    init {
        require(roundCount > 0) {
            "레이싱 횟수는 최소 1회 이상 요청해 주세요."
        }
    }
}
