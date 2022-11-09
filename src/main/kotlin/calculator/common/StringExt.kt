package calculator.common

import calculator.operator.Operator

fun String.isNumber(): Boolean {
    val result = toIntOrNull()
    return result != null
}

fun String.isNotNumber(): Boolean = isNumber().not()

fun String.isOperator(): Boolean {
    Operator
        .values()
        .forEach { operator ->
            if (operator.isEqualSign(this)) return true
        }
    return false
}

fun String.isNotOperator(): Boolean = isOperator().not()

fun String.toOperator(): Operator {
    check(isOperator()) { "this string is not operator" }
    Operator
        .values()
        .forEach {
            if (it.isEqualSign(this)) return it
        }
    throw IllegalArgumentException("not found operator")
}
