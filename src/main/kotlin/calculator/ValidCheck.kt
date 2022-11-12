package calculator

object ValidCheck {
    @Throws(IllegalArgumentException::class)
    fun checkValid(input: String?): Boolean {
        return checkEmptyString(input) && checkSplitArrayCount(input?.split(" "))
    }

    @Throws(IllegalArgumentException::class)
    fun checkSplitArrayCount(split: List<String>?): Boolean {
        require((split?.size ?: 0) < 3) { "문자열에 숫자나 연산자 개수 부족" }
        require((split?.size ?: 0) % 2 == 0) { "문자열에 숫자나 연산자 개수 부족" }
        return true
    }

    @Throws(IllegalArgumentException::class)
    fun checkEmptyString(input: String?): Boolean {
        require(!input.isNullOrBlank()) { "입력값이 null 이거나 빈 공백 문자" }
        return true
    }
}
