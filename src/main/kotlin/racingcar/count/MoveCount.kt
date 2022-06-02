package racingcar.count

class MoveCount(val value: Int, minCount: Int = 1) {
    init {
        require(minCount >= 1) { "최소이동횟수는 1 이상이어야 합니다" }
        require(value >= minCount) { "이동횟수는 최소 $minCount 이상이어야 합니다" }
    }

    companion object {
        const val inputMessage = "시도할 횟수는 몇 회인가요?"
    }
}
