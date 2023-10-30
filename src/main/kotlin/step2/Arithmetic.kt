package step2

import java.lang.IllegalArgumentException

enum class Arithmetic(
    val expr: String,
    private val function: (Int, Int) -> Int
) {
    PLUS("+", { operand1, operand2 -> operand1 + operand2 }),
    MINUS("-", { operand1, operand2 -> operand1 - operand2 }),
    TIMES("*", { operand1, operand2 -> operand1 * operand2 }),
    DIVIDE("/", { operand1, operand2 -> operand1 / operand2 });

    fun calculate(operand1: Int, operand2: Int): Int = function.invoke(operand1, operand2)

    companion object {
        fun findBy(expr: String): Arithmetic = values().find { expr == it.expr }
            ?: throw IllegalArgumentException()
    }
}
