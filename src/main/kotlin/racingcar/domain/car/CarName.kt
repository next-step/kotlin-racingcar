package racingcar.domain.car

data class CarName(
    val value: String
) {
    init {
        require(value.length <= MAX_LENGTH) { "자동차 이름은 $MAX_LENGTH 를 넘을 수 없습니다." }
        require(value.isNotBlank()) { "자동차 이름은 공백만으로 이루어질 수 없습니다." }
    }

    companion object {
        const val MAX_LENGTH = 5
    }
}
