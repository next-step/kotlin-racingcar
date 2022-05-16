class StringCalculator {
    fun calculate(input: String?): Double {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 null 혹은 빈 값입니다.")
        }
        return 0.0
    }
}
