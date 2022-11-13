package calculator

class Calculator {
    fun calculate(input: String?): Int {
        val data = validateNullCheck(input)
        val splitedDatas = data.split(" ")
        val operators = extractOperators(splitedDatas)
        var operands = extractOperands(splitedDatas)

        var calculatedValue = operands.first()
        operands = operands.drop(1)

        operands.forEachIndexed { index, number ->
            val operator = operators[index]
            calculatedValue = operator.calculate(calculatedValue, number)
        }
        return calculatedValue
    }

    private fun extractOperands(input: List<String>): List<Int> {
        val operand = mutableListOf<Int>()
        input.forEach {
            if (it.toIntOrNull() != null) {
                operand.add(it.toInt())
            }
        }
        return operand
    }

    private fun extractOperators(input: List<String>): List<Operator> {
        val operators = mutableListOf<Operator>()
        input.forEach {
            if (it.toIntOrNull() == null) {
                operators.add(Operator.valueOfSymbol(it))
            }
        }
        return operators
    }

    private fun validateNullCheck(data: String?): String {
        require(!data.isNullOrEmpty()) { "input data is null, please check data" }
        return data
    }
}
