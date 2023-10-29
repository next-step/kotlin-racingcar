package calculator

class StringCalculator {

    companion object {
        private const val DELIMITER = " "
    }

    fun execute(input: String): Int {
        val elements = parse(input)
        return elements.calculate()
    }

    private fun parse(input: String): Elements {
        validateInput(input)
        return Elements.of(input, DELIMITER)
    }

    private fun validateInput(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력값은 빈 공백 문자일 수 없습니다")
        }
    }
}
