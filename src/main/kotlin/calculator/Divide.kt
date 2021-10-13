package calculator

import java.math.BigDecimal

class Divide : Operation {
    companion object {
        const val CANNOT_BE_DIVIDED_BY_ZERO = "0으로 나눌 수 없습니다."
    }

    override fun calculate(firstOperand: BigDecimal, secondOperand: BigDecimal): BigDecimal {
        if (secondOperand == BigDecimal.ZERO) {
            throw IllegalArgumentException(CANNOT_BE_DIVIDED_BY_ZERO)
        }

        return firstOperand / secondOperand
    }
}
