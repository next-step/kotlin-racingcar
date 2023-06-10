package calculator

import java.math.BigDecimal

object Calculator {
    @Throws(IllegalArgumentException::class)
    fun calculate(input: String): BigDecimal {
        ExpressionVerifier.verify(input)

        val elements = ExpressionFormatter.format(input)

        var result = elements[0].toBigDecimal()

        for (i in 1 until elements.size - 1) {
            if (i % 2 == 0) {
                continue
            }
            result = elements[i].toOperation().execute(result, elements[i + 1].toBigDecimal())
        }
        return result
    }
}
