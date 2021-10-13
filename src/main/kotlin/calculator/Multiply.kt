package calculator

import java.math.BigDecimal

class Multiply : Operation {
    override fun calculate(firstOperand: BigDecimal, secondOperand: BigDecimal): BigDecimal =
        firstOperand * secondOperand
}
