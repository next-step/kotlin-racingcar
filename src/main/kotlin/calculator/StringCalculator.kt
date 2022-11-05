package calculator

import calculator.service.StringCalculatorProcessor
import java.math.BigDecimal

private const val DELIMITER = " "

object StringCalculator {
    fun calculate(input: String?): BigDecimal {
        require(!input.isNullOrBlank())
        return StringCalculatorProcessor(input.split(DELIMITER)).process()
    }
}
