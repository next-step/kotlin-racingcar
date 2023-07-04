package racingcar.domain.car

data class CarName(val value: String) {
    init {
        require(value.trim().length in NAME_LENGTH_RANGE) { "자동차 이름은 1자 이상, 5자 이하만 가능합니다." }
    }

    companion object {
        private val NAME_LENGTH_RANGE = 1..5
    }
}
