package calculator

class StringCalculator {
    companion object {
        fun calculate(input: String?) {
            if (input.isNullOrBlank()) {
                throw IllegalArgumentException()
            }
        }
    }
}
