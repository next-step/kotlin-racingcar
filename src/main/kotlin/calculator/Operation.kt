package calculator

import java.math.BigDecimal
import java.math.RoundingMode

enum class Operation(val execute: (BigDecimal, BigDecimal) -> BigDecimal) {
    ADD({ num1, num2 ->
        num1.add(num2)
    }),

    SUBTRACT({ num1, num2 ->
        num1.subtract(num2)
    }),

    MULTIPLY({ num1, num2 ->
        num1.multiply(num2)
    }),

    DIVIDE({ num1, num2 ->
        require(num2 != BigDecimal.ZERO) { "Not divisible by zero" }
        num1.divide(num2, 6, RoundingMode.HALF_UP)
    }),
}
