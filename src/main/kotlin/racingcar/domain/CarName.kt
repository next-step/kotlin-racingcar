package racingcar.domain

@JvmInline
value class CarName(
    val name: String
) {
    init {
        require(name.isNotBlank()) { "자동차의 이름은 공백이 들어올 수 없다" }
        require(name.length < 5) { "자동차의 이름을 5자를 초과할 수 없다" }
    }
}
