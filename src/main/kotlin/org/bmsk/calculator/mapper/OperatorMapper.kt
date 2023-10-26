package org.bmsk.calculator.mapper

import org.bmsk.calculator.model.Operator

internal fun String.toOperator(): Operator {
    return when (this) {
        Operator.Plus.symbol -> Operator.Plus
        Operator.Minus.symbol -> Operator.Minus
        Operator.Times.symbol -> Operator.Times
        Operator.Division.symbol -> Operator.Division
        else -> throw IllegalArgumentException("$this.toOperator(): ${this}는 정의되지 않은 연산자.")
    }
}
