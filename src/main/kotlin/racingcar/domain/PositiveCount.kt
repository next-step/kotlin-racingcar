package racingcar.domain

class PositiveCount(val value: Int) {

    init {
        require(value > 0) { "자연수이어야 합니다" }
    }

    constructor(value: String) : this(value.toIntOrNull() ?: throw IllegalArgumentException("자연수이어야 합니다"))
}
