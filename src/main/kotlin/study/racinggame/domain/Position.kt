package study.racinggame.domain

data class Position (val value: Int = 1) {
    init {
        if (value < 1) {
            throw CanNotNegativePositionException(value)
        }
    }
    fun move(value: Int = 1): Position {
        return Position(this.value + value)
    }

}

class CanNotNegativePositionException (value: Int) : RuntimeException("위치값은 0보다 작을 수 없습니다. (value = $value)")
