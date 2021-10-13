package calculator

import java.math.BigDecimal

class Subtract : Operation {
    override fun calculate(firstOperand: BigDecimal, secondOperand: BigDecimal): BigDecimal =
        firstOperand - secondOperand
}
