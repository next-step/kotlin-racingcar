package calculator.domain

import java.util.function.BinaryOperator

data class Operator(val signString: String) {
    private val sign: Sign

    init {
        sign = Sign.values()
            .firstOrNull { sign: Sign -> sign.isSameSign(signString) } ?: throw IllegalArgumentException()
    }

    fun operate(operand1: Operand, operand2: Operand): Operand {
        return sign.operate(operand1, operand2)
    }

    private enum class Sign(private val value: String, private val operator: BinaryOperator<Operand>) {
        PLUS("+", Operand::sum),
        MINUS("-", Operand::subtract),
        MULTIPLY("*", Operand::multiply),
        DIVIDE("/", Operand::divide);

        fun isSameSign(sign: String): Boolean {
            return value == sign
        }

        fun operate(operand1: Operand, operand2: Operand): Operand {
            return operator.apply(operand1, operand2)
        }
    }
}
