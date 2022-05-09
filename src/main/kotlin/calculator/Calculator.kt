package calculator

class Calculator {
    private fun calculateByOperation(operation: String, total: Float, num: Float): Float {
        when (operation) {
            "+" -> {
                return total + num
            }
            "-" -> {
                return total - num
            }
            "*" -> {
                return total * num
            }
            "/" -> {
                return total / num
            }
            else -> {
                throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }
        }
    }

    fun calculate(formula: String?): Float {
        if (formula.isNullOrEmpty()) {
            throw IllegalArgumentException("올바은 계산식이 아닙니다.")
        }

        val formulas = formula.split(" ")
        val numbers = Util.groupByIsNumber(formulas, true).map { it.toFloat() }
        val operations = Util.groupByIsNumber(formulas, false)

        var total = numbers[0]



        for ((index, num) in numbers.drop(1).withIndex()) {
            total = calculateByOperation(operations[index], total, num)
        }

        return total
    }
}
