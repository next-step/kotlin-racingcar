package racingcar.model

@JvmInline
value class CarName(
    val name: String
) {
    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        validateNameSize(name)
        validateIsBlank(name)
    }

    private fun validateIsBlank(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("차의 이름이 공백입니다.")
        }
    }

    private fun validateNameSize(name: String) {
        if (name.length > 5) {
            throw IllegalArgumentException("차이 이름이 5자보다 큽니다.")
        }
    }
}
