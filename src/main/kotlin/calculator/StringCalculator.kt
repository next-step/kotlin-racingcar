package calculator

class StringCalculator {
    fun calculate(input: String?): Double {
        val equation = validateEmpty(input)
        var (result, operand, operator) = initialize()

        val splitEquation = equation.split(" ")

        for ((index, element) in splitEquation.withIndex()) {
            if (index % 2 == 0) {
                operand = element.toDoubleOrNull() ?: throw IllegalArgumentException("입력값이 잘못되었습니다.")
                result = operator.operate(result, operand)
            } else {
                operator = Operator.toOperator(element) ?: throw IllegalArgumentException("입력값이 잘못되었습니다.")
            }
        }

        return result
    }

    private fun validateEmpty(input: String?): String {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 null 혹은 빈 값입니다.")
        }
        return input
    }

    private fun initialize(): Triple<Double, Double, Operator> {
        var result = 0.0
        var operand = 0.0
        var operator = Operator.PLUS

        return Triple(result, operand, operator)
    }
}
