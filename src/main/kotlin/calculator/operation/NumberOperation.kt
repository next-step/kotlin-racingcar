package calculator.operation

import java.math.BigDecimal

class NumberOperation(value: String) : InfixOperation {
    private val value: BigDecimal
    init {
        require(value.matches("[0-9]+".toRegex())) { "$value 는 숫자여야합니다." }
        this.value = BigDecimal(value)
    }
    override fun operate(): BigDecimal = this.value
}
