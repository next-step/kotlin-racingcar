package calculator

class Calculator {
    fun calculate(input: String?): Int {
        val removedSpaceInput = removeSpace(input)
        val data = validateNullCheck(removedSpaceInput)
        val operators = extractOperators(data)
        var operands = extractOperands(data)

        var calculatedValue = operands.first()
        operands = operands.drop(1)

        operands.forEachIndexed { index, number ->
            val operator = operators[index]
            calculatedValue = operator.calculate(calculatedValue, number)
        }
        return calculatedValue
    }

    private fun extractOperands(input: String): List<Int> {
        val operand = mutableListOf<Int>()
        var foundNumber = ""
        input.forEach {
            if (it.digitToIntOrNull() != null) {
                foundNumber += it
                return@forEach
            }
            operand.add(foundNumber.toInt())
            foundNumber = ""
        }
        operand.add(foundNumber.toInt())

        return operand
    }

    private fun extractOperators(input: String): List<Operator> {
        val operators = mutableListOf<Operator>()
        input.forEach {
            if (it.digitToIntOrNull() == null) {
                operators.add(Operator.valueOfSymbol(it.toString()))
            }
        }
        return operators
    }

    private fun removeSpace(data: String?): String? = data?.replace(" ", "")

    private fun validateNullCheck(data: String?): String {
        require(!data.isNullOrEmpty()) { throw IllegalArgumentException("input data is null, please check data") }
        return data
    }
}
