package racingcar

@JvmInline
value class CarPosition(val value: Int) : Comparable<CarPosition> {
    init {
        require(value >= ZERO) { POSITION_UNDER_ZERO_MESSAGE }
    }

    fun advance(): CarPosition {
        return CarPosition(value + ADVANCE_VALUE)
    }

    override fun compareTo(other: CarPosition): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        private const val ZERO = 0
        private const val ADVANCE_VALUE = 1
        private const val POSITION_UNDER_ZERO_MESSAGE = "위치는 음수일 수 없습니다."

        fun startPosition(): CarPosition {
            return CarPosition(ZERO)
        }
    }
}
