package racingcar

data class CarName(private val value: String) {
    init {
        require(this.value.isNotBlank()) { "자동차의 이름은 빈 값이나 공백이 될 수 없습니다. name: ${this.value}" }
    }
}
