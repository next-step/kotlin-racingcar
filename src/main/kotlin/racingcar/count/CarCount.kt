package racingcar.count

class CarCount(val value: Int, minCount: Int = 1) {
    init {
        require(minCount >= 1) { "최소 자동차 수는 1 이상이어야 합니다." }
        require(value >= minCount) { "자동차 수는 최소 $minCount 이상이어야 합니다." }
    }
}
