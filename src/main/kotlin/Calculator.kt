import java.math.BigDecimal
import java.math.MathContext

class Calculator {
    private fun add(i: BigDecimal, j: BigDecimal): BigDecimal =
        i.add(j)

    private fun subtract(i: BigDecimal, j: BigDecimal): BigDecimal =
        i.subtract(j)

    private fun multiply(i: BigDecimal, j: BigDecimal): BigDecimal =
        i.multiply(j)

    private fun divide(i: BigDecimal, j: BigDecimal): BigDecimal =
        i.divide(j, MathContext.DECIMAL64)

    fun calculate(strNum1: String?, strNum2: String?, operator: String): String {
        val i = strNum1?.toBigDecimalOrNull() ?: throw IllegalArgumentException()
        val j = strNum2?.toBigDecimalOrNull() ?: throw IllegalArgumentException()
        return when (operator) {
            Operator.ADD.symbol -> add(i, j)
            Operator.MINUS.symbol -> subtract(i, j)
            Operator.MULTIPLE.symbol -> multiply(i, j)
            Operator.DIVIDE.symbol -> divide(i, j)
            else -> throw IllegalArgumentException()
        }.toString()
    }
}
