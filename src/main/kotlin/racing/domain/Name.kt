package racing.domain

class Name(val value: String) {
    init {
        require(value.trim().length <= NAME_MAX_LENGTH)
    }

    companion object {
        private const val NAME_MAX_LENGTH = 5
    }
}
