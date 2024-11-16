package race

data class Name(val value: String) {
    init {
        require(value.isNotBlank()) { "공백이 아닌 문자열 이어야 합니다." }
        require(value.length <= MAX_NAME_LENGTH) { "{$MAX_NAME_LENGTH}자 이하로 입력해주세요." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
