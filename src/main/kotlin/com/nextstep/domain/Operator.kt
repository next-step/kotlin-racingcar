package com.nextstep.domain

enum class Operator(private val operator: String) {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVISION("/");

    companion object {
        fun valueOfOperator(operatorValue: String): Operator {
            val operator = values().find { operator -> operator.operator == operatorValue }

            return operator ?: throw IllegalArgumentException("값이 존재하지 않습니다")
        }
    }
}
