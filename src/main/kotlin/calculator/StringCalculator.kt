package calculator

import calculator.service.StringCalculatorProcessor
import java.math.BigDecimal

private const val DELIMITER = " "

class StringCalculator {
    companion object {
        fun calculate(input: String?): BigDecimal {
            require(!input.isNullOrBlank())
            return StringCalculatorProcessor(input.split(DELIMITER)).process()
        }
    }
}
