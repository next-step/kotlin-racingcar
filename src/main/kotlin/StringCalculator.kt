class StringCalculator {
    fun calculate(input: String): Int {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.")
        }

        input.split(" ").forEach {
            println(it)
        }

        return 0
    }
}
