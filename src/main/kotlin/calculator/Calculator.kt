package calculator

class Calculator {
    fun calculate(input: String?): Int {
        val removedSpaceInput = removeSpace(input)
        val data = validateNullCheck(removedSpaceInput)
        val (operators, numbers) = splitOperandWithNumber(data)
        var result = 0

        numbers.forEachIndexed { index, number ->
            val operand = Operand.valueOfSymbol(operators[index])
            result = operand.calc(result, number)
        }
        return result
    }

    private fun splitOperandWithNumber(data: String): Pair<List<String>, List<Int>> {
        val numbers = mutableListOf<Int>()
        val operators = mutableListOf("+")
        var number = ""
        data.forEach {
            if (it.digitToIntOrNull() != null) {
                number += it
                return@forEach
            }
            operators.add(it.toString())
            numbers.add(number.toInt())
            number = ""
        }
        numbers.add(number.toInt())
        return Pair(operators, numbers)
    }

    private fun removeSpace(data: String?): String? {
        return data?.replace(" ", "")
    }

    private fun validateNullCheck(data: String?): String {
        if (data.isNullOrEmpty()) {
            throw IllegalArgumentException("input data is null, please check data")
        }
        return data
    }
}
