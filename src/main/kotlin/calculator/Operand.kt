package calculator

import jdk.internal.joptsimple.internal.Strings
import java.math.BigDecimal

class Operand(input: String?) {
    private val value: BigDecimal

    companion object {
        const val WRONG_OPERAND_INPUT = "잘못된 피연산자 입력입니다."
    }

    init {
        require(Strings.isNullOrEmpty(input)) { WRONG_OPERAND_INPUT }
        this.value = BigDecimal(input)
    }
}
