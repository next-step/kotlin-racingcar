package calculator.common

import calculator.common.Constant.DivideCharacter
import calculator.common.Constant.MinusCharacter
import calculator.common.Constant.MultiplyCharacter
import calculator.common.Constant.PlusCharacter
import calculator.operator.DivideOperator
import calculator.operator.MinusOperator
import calculator.operator.MultiplyOperator
import calculator.operator.Operator
import calculator.operator.PlusOperator

fun String.isNumber(): Boolean {
    val result = toIntOrNull()
    return result != null
}

fun String.isNotNumber(): Boolean = isNumber().not()

fun String.isOperator(): Boolean {
    val result = when (this) {
        PlusCharacter, MinusCharacter, MultiplyCharacter, DivideCharacter -> true
        else -> false
    }
    return result
}

fun String.isNotOperator(): Boolean = isOperator().not()

fun String.toOperator(): Operator {
    return when (this) {
        PlusCharacter -> PlusOperator
        MinusCharacter -> MinusOperator
        MultiplyCharacter -> MultiplyOperator
        DivideCharacter -> DivideOperator
        else -> throw UnsupportedOperationException("transform fail to Operator")
    }
}
