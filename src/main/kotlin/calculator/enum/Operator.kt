package calculator.enum

import java.lang.IllegalArgumentException

enum class Operator(val operatorStr: String, val calculate: (num1: Long, num2: Long) -> Long) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLE("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 });
    companion object {
        fun findBy(operatorStr: String): Operator {
            return values().find { it.operatorStr == operatorStr } ?: throw IllegalArgumentException("잘못된 연산자에요. $operatorStr")
        }
    }
}
