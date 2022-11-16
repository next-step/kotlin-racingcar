package calculator

object ValidCheck {
    fun checkValid(input: String?) {
        checkSplitArrayCount(checkEmptyString(input).split(" "))
    }

    fun checkEmptyString(input: String?): String {
        require(!input.isNullOrBlank()) { "입력값이 null 이거나 빈 공백 문자" }
        return input
    }

    fun checkSplitArrayCount(split: List<String>) {
        checkSplit(split.size >= 3) { "문자열에 숫자나 연산자 개수 부족" }
        checkSplit(split.size % 2 != 0) { "문자열에 숫자나 연산자 개수 부족" }
    }

    fun checkSplitArrayOperator(input: String) {
        input.calculateOperationList()
    }

    private inline fun checkSplit(value: Boolean, lazyMessage: () -> Any) {
        if (!value) {
            val message = lazyMessage()
            throw StringSplitCountInvalidException(message.toString())
        }
    }
}
