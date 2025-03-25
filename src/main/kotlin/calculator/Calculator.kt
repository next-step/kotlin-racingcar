package calculator

object Calculator {
    fun compute(input: String): Int {
        validateInput(input)
        val inputList = input.toInputList()
        return calculate(inputs = inputList)
    }

    fun validateInput(input: String?): String {
        if (input.isNullOrBlank()) throw IllegalArgumentException("Input is null or blank")
        if (input.any { it !in ALLOWED_CHARS }) throw IllegalArgumentException("Input has invalid characters")
        return input
    }

    private fun calculate(inputs: List<String>): Int {
        if (inputs.isEmpty()) {
            throw IllegalArgumentException("No valid inputs provided")
        }
        var result =
            inputs[0].toIntOrNull() ?: throw IllegalArgumentException("Invalid number:${inputs[0]}")
        var index = 1
        while (index < inputs.size) {
            val operator = Operator.toOperator(inputs[index])
            val next =
                inputs.getOrNull(index + 1)?.toIntOrNull()
                    ?: throw IllegalArgumentException("Number is expected after operator")
            result = operator.operate(result, next)
            index += 2
        }
        return result
    }

    private fun String.toInputList(): List<String> = this
        .split(" ")
        .filter { it.isNotEmpty() }
}

const val ALLOWED_CHARS = "0123456789+-*/ "
