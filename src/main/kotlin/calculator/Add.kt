package calculator

import java.math.BigDecimal

class Add : Operation {
    override fun calculate(firstOperand: BigDecimal, secondOperand: BigDecimal): BigDecimal =
        firstOperand + secondOperand
}
