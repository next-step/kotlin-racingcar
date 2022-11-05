package calculator.service

import calculator.model.Calculation
import java.math.BigDecimal

class StringCalculatorProcessor(
    val input: List<String>
) {
    var accumulator: BigDecimal? = null
    var calculation: Calculation? = null

    fun process() {
        TODO("Not yet implemented")
    }
}
