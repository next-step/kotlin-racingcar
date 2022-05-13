package com.nextstep.jngcii.step2

enum class Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE;

    companion object {
        fun of(input: String) = when (input) {
            "+" -> PLUS
            "-" -> MINUS
            "*" -> MULTIPLY
            "/" -> DIVIDE
            else -> throw IllegalArgumentException("연산자는 '+, -, *, /'만 입력 가능합니다.")
        }
    }
}
