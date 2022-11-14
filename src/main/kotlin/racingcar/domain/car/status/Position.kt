package racingcar.domain.car.status

private const val DEFAULT_POSITION = 0

data class Position(val value: Int) {
    init {
        require(value >= DEFAULT_POSITION) { "자동차의 위치는 0 이상이어야 합니다." }
    }
}
