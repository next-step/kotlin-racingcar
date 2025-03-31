package calculator

object Calculator {
    fun compute(input: String): Int {
        val inputList = validateInput(input)
        return calculate(inputList = inputList)
    }

    fun validateInput(input: String?): List<String> {
        require(!input.isNullOrBlank()) { "Input is null or blank" }
        require(input.all { it in ALLOWED_CHARS }) { "Input has invalid characters" }
        val inputList = input.toInputList()
        require(inputList.isNotEmpty()) { "No valid inputs provided" }
        return inputList
    }

    private fun calculate(inputList: List<String>): Int {
        var result =
            inputList[0].toIntOrNull()
                ?: throw IllegalArgumentException("Invalid number:${inputList[0]}")
        var index = 1
        while (index < inputList.size) {
            val operator = Operator.toOperator(inputList[index])
            val next =
                inputList.getOrNull(index + 1)?.toIntOrNull()
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
