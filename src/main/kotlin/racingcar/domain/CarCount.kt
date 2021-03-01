package racingcar.domain

class CarCount(val value: Int) {

    init {
        require(value > 0) { "자동차 대수는 자연수이어야 합니다" }
    }

    constructor(value: String) : this(value.toIntOrNull() ?: throw IllegalArgumentException("자동차 대수는 자연수이어야 합니다"))
}
