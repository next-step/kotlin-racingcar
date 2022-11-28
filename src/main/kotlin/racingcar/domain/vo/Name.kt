package racingcar.domain.vo

data class Name(val name: String) {
    init {
        require(name.trim().length in MIN_LENGTH..MAX_LENGTH) { "name length should be between $MIN_LENGTH and $MAX_LENGTH" }
    }

    companion object {
        private const val MIN_LENGTH = 1
        private const val MAX_LENGTH = 5
    }
}
