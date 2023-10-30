package racingcar.domain

class Position(initValue: Int = MIN_POSITION) {

    var value: Int = initValue
        private set

    init {
        require(initValue in MIN_POSITION..MAX_POSITION) {
            "$MIN_POSITION ~ $MAX_POSITION 사이의 포지션만 입력할 수 있습니다."
        }
    }

    fun plus(other: Position) {
        this.value += other.value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Position) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    companion object {
        private const val MIN_POSITION = 0
        private const val MAX_POSITION = Int.MAX_VALUE
    }
}
