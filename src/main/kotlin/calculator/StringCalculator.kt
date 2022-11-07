package calculator

import calculator.service.StringCalculatorProcessor
import java.math.BigDecimal

private const val DELIMITER = " "

object StringCalculator {
    fun calculate(input: String?): BigDecimal {
        require(!input.isNullOrBlank()) { "빈 문자열은 계산할 수 없습니다." }
        return StringCalculatorProcessor(input.split(DELIMITER)).process()
    }
}
