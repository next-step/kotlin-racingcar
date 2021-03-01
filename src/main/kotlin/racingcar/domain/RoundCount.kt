package racingcar.domain

class RoundCount(val value: Int) {

    init {
        require(value > 0) { "라운드 수는 자연수이어야 합니다" }
    }

    constructor(value: String) : this(value.toIntOrNull() ?: throw IllegalArgumentException("라운드 수는 자연수이어야 합니다"))
}
