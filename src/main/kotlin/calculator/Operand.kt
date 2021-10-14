package calculator

import jdk.internal.joptsimple.internal.Strings
import java.math.BigDecimal

data class Operand(val value: BigDecimal) {
    companion object {
        private const val WRONG_OPERAND_INPUT = "잘못된 피연산자 입력입니다."
        fun from(input: String?): Operand {
            require(!(Strings.isNullOrEmpty(input))) { WRONG_OPERAND_INPUT }
            return Operand(BigDecimal(input))
        }
    }
}
