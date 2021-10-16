package calculator

import java.math.BigDecimal

data class Operand(val value: BigDecimal) {
    companion object {
        const val WRONG_OPERAND_INPUT = "잘못된 피연산자 입력입니다."
        fun from(input: String?): Operand {
            val inputOperandValue = input?.toBigDecimalOrNull()
            require(inputOperandValue != null) { WRONG_OPERAND_INPUT }
            return Operand(inputOperandValue)
        }
    }
}
