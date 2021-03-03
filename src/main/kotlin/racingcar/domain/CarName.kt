package racingcar.domain

class CarName(input: String) {

    val value: String

    init {
        require(input.isNotBlank()) { "자동차 이름은 공백이 될 수 없습니다" }
        value = input.trim()
    }
}
