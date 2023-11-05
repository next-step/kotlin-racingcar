package racingcar.domain

class Name(
    private val name: String,
) {
    init {
        validateNameLength()
    }

    private fun validateNameLength() {
        if (name.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("이름은 5자를 초과할 수 없다.")
        }
    }

    fun getName(): String {
        return name
    }

    companion object {
        const val MAX_NAME_LENGTH = 5
    }
}
