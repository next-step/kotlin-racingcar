package study.racinggame.domain

@JvmInline
value class Position (val value: Int = 1) {
    init {
        if (value < 1) {
            throw CanNotNegativePositionException(value)
        }
    }
}

class CanNotNegativePositionException (value: Int) : RuntimeException("위치값은 0보다 작을 수 없습니다. (value = $value)")
