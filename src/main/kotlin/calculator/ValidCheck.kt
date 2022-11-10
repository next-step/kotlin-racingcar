package calculator

object ValidCheck {
    @Throws(IllegalArgumentException::class)
    fun checkValid(input: String?): Boolean {
        return checkEmptyString(input) && checkSplitArrayCount(input?.split(" "))
    }

    @Throws(IllegalArgumentException::class)
    fun checkSplitArrayCount(split: List<String>?): Boolean {
        if ((split?.size ?: 0) < 3) throw IllegalArgumentException("문자열에 숫자나 연산자 개수 부족")
        if ((split?.size ?: 0) % 2 == 0) throw IllegalArgumentException("문자열에 숫자나 연산자 개수가 맞지 않음")

        return true
    }

    @Throws(IllegalArgumentException::class)
    fun checkEmptyString(input: String?): Boolean {
        if (input.isNullOrBlank())
            throw IllegalArgumentException("입력값이 null 이거나 빈 공백 문자")

        return true
    }
}
