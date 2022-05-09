package calculator

class Calculator {
    fun calculate(formula: String?): Float {
        if (formula.isNullOrEmpty()) {
            throw IllegalArgumentException("올바은 계산식이 아닙니다.")
        }

        val formulas = formula.split(" ")
        val numbers = Util.groupByIsNumber(formulas, true).map { it.toFloat() }
        val operations = Util.groupByIsNumber(formulas, false)

        var total = numbers[0]

        

        for ((index, el) in numbers.drop(1).withIndex()) {
            when {
                operations[index] == "+" -> {
                    total += el
                }
                operations[index] == "-" -> {
                    total -= el
                }
                operations[index] == "*" -> {
                    total *= el
                }
                operations[index] == "/" -> {
                    total /= el
                }
                else -> {
                    throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
                }
            }
        }

        return total
    }
}
