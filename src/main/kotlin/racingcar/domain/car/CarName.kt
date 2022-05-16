package racingcar.domain.car

data class CarName(
    val value: String
) {
    init {
        validateBlank(this.value)
        validateLength(this.value)
    }

    private fun validateLength(value: String) {
        if (MAX_LENGTH < value.length) {
            throw IllegalArgumentException("자동차 이름은 $MAX_LENGTH 를 넘을 수 없습니다.")
        }
    }

    private fun validateBlank(value: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("자동차 이름은 공백만으로 이루어질 수 없습니다.")
        }
    }

    companion object {
        const val MAX_LENGTH = 5
    }
}
