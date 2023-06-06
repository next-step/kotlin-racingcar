package next.step.calculator.domain

import next.step.calculator.domain.exception.IllegalOperatorFormatException
import java.util.function.BinaryOperator

enum class Operator(
    private val symbol: String,
    private val operator: BinaryOperator<InputNumber>
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    TIMES("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun from(symbol: String?): Operator {
            return values().find { it.symbol == symbol } ?: throw IllegalOperatorFormatException()
        }
    }

    fun evaluate(a: InputNumber, b: InputNumber): InputNumber = operator.apply(a, b)
}
