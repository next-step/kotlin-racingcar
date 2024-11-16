package racingcar.domain.vo

@JvmInline
value class CarName(val value: String) {
    init {
        require(value.length in 1..5) { "자동차 이름은 1자 이상, 5자 이하만 가능합니다." }
    }
}
