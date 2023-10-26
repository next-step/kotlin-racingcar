package org.bmsk.calculator.util

import org.bmsk.calculator.model.Operator

internal fun String.isOperator(): Boolean = Operator.values().any { it.symbol == this }

internal fun String.isNumeric(): Boolean = try {
    this.toFloat()
    true
} catch (e: NumberFormatException) {
    false
}
