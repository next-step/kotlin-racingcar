package calculator

import calculator.enum.Operator

data class CalculateInfo(
    val first: Long,
    val second: Long,
    val op: Operator,
) {
    fun doCalculate(): Long {
        return op.calculate(first, second)
    }
}
