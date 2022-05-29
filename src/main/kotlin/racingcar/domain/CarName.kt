package racingcar.domain

@JvmInline
value class CarName private constructor(val value: String) {

    companion object {
        fun of(value: String): CarName {
            require(value.isNotBlank()) { "자동차의 이름은 빈 값이나 공백이 될 수 없습니다. name: $value" }
            return CarName(value.trim())
        }
    }
}
