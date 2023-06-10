package calculator.operation

import java.math.BigDecimal

class MockOperator : InfixOperation {
    override fun operate(): BigDecimal = BigDecimal.ZERO
}
