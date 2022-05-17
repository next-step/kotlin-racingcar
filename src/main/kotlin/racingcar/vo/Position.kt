package racingcar.vo

private const val MINIMUM_POSITION_VALUE = 0

data class Position(
    val value: Int = MINIMUM_POSITION_VALUE
) {
    init {
        require(value >= MINIMUM_POSITION_VALUE) {
            "자동차의 위치는 음수일 수 없습니다."
        }
    }
}