package racingcar.count

class MoveCount(val value: Int, minCount: Int = 1) {
    init {
        require(value >= minCount) { "이동횟수는 최소 $minCount 이상이어야 합니다" }
    }
}
