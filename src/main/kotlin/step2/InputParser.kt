package step2

class InputParser {

    companion object {
        val ARITHMETIC_SYMBOLS = listOf("+", "-", "*", "/")
    }

    fun parse(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("인자로는 null 또는 빈값이 올 수 없습니다. $input")
        }

        val inputs = input.split(" ")

        inputValidate(inputs, input)

        return inputs
    }

    private fun inputValidate(inputs: List<String>, input: String?) {
        inputs.forEach {
            it.toDoubleOrNull()
                ?: toArithmeticSymbolOrNull(it)
                ?: throw IllegalArgumentException("입력문자에는 숫자 또는 사칙연산 기호만 올 수 있습니다. $input")
        }
    }

    private fun toArithmeticSymbolOrNull(str: String): String? {
        if (ARITHMETIC_SYMBOLS.contains(str)) {
            return str
        }

        return null
    }
}
