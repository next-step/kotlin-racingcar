package racingcar.domain

data class Nickname(val value: String) {

    init {
        require(value.length in MIN_LENGTH..MAX_LENGTH) {
            "닉네임은 ${MIN_LENGTH}자 이상 ${MAX_LENGTH}자 이하만 가능합니다."
        }
    }

    companion object {
        private const val MIN_LENGTH = 1
        private const val MAX_LENGTH = 5
    }
}
