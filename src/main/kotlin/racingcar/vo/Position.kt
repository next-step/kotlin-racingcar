package racingcar.vo

private const val MINIMUM_POSITION_VALUE = 0
private const val MOVE_UNIT = 1

class Position(var value: Int = MINIMUM_POSITION_VALUE) {
    init {
        require(value >= MINIMUM_POSITION_VALUE) {
            "자동차의 위치는 음수일 수 없습니다."
        }
    }

    fun move() {
        this.value = value + MOVE_UNIT
    }
}
