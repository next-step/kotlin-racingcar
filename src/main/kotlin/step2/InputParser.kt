package step2

class InputParser {

    fun parse(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("인자로는 null 또는 빈값이 올 수 없습니다. $input")
        }

        val inputs = input.split(" ")

        validateInput(inputs, input)

        return inputs
    }

    private fun validateInput(inputs: List<String>, input: String?) {
        inputs.forEach {
            it.toDoubleOrNull()
                ?: it.toArithmeticSymbolOrNull()
                ?: throw IllegalArgumentException("입력문자에는 숫자 또는 사칙연산 기호만 올 수 있습니다. $input")
        }
    }
}
