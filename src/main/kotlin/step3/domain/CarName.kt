package step3.domain

data class CarName(
    private val value: String
) {
    init {
        require(value.isNotBlank() && value.length <= MAXIMUM_NAME_LENGTH) { "이름은 5자 이하여야 합니다" }
    }

    companion object {
        private const val MAXIMUM_NAME_LENGTH = 5
    }

    override fun toString(): String {
        return value
    }
}
