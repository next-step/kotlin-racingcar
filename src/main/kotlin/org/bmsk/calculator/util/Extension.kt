package org.bmsk.calculator.util

import org.bmsk.calculator.model.Operator

internal fun String.isOperator() = this in listOf(
    Operator.Plus.symbol,
    Operator.Minus.symbol,
    Operator.Times.symbol,
    Operator.Division.symbol,
)

internal fun String.isNumeric(): Boolean = try {
    this.toFloat()
    true
} catch (e: NumberFormatException) {
    false
}
