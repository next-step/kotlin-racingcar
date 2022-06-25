package racingcar.domain

private const val DEFAULT_MOVEMENT = 0

class Movement(val value: Int) {

    init {
        require(value >= 0) { "이동거리는 0 보다 작을 수 없습니다." }
    }

    constructor() : this(DEFAULT_MOVEMENT)
}
