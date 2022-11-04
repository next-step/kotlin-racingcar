package calculator.domain

import java.util.function.BinaryOperator

enum class Operator(private val sign: String, private val operation: BinaryOperator<Operand>) {
    PLUS("+", Operand::sum),
    MINUS("-", Operand::subtract),
    MULTIPLY("*", Operand::multiply),
    DIVIDE("/", Operand::divide);

    fun isSameSign(sign: String): Boolean {
        return this.sign == sign
    }

    fun operate(operand1: Operand, operand2: Operand): Operand {
        return operation.apply(operand1, operand2)
    }

    companion object {
        fun from(sign: String): Operator {
            return values()
                .firstOrNull { operator: Operator -> operator.isSameSign(sign) } ?: throw IllegalArgumentException()
        }
    }
}
