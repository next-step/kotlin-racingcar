package step2.calculator.vo

import java.util.function.BiFunction

enum class Operation(
    private val value: String,
    private val operation: BiFunction<Number, Number, Number>
) : CalculatorInput {
    PLUS("+", { op1, op2 -> Number(op1.value + op2.value) }),
    MINUS("-", { op1, op2 -> Number(op1.value - op2.value) }),
    DIVIDE("/", { op1, op2 -> Number(op1.value / op2.value) }),
    MULTI("*", { op1, op2 -> Number(op1.value * op2.value) });

    fun calculate(op1: Number, op2: Number): Number {
        return this.operation.apply(op1, op2)
    }
}
