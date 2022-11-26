package racing.domain

class Name(
    value: String,
) : Comparable<Name> {
    private val value: String = value.trim()

    init {
        require(value.isNotBlank() && value.length <= MAX_NAME_LENGTH) { "이름은 1~${MAX_NAME_LENGTH}글자여야 합니다." }
    }

    override fun compareTo(other: Name): Int {
        return value.compareTo(other.value)
    }

    override fun toString(): String {
        return value
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
