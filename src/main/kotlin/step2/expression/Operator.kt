package step2.expression

import java.lang.IllegalArgumentException

/**
 * ### 연산식의 요소 중 하나인 '연산자' 입니다.
 *
 * 연산 문자를 구체적인 연산자 타입으로 맵핑하는 역할과 연산 메서드를 호출하는 역할을 합니다.
 */
sealed class Operator : ExpressionItem {

    companion object {
        fun of(value: String): Operator {
            return when (value) {
                "+" -> Plus(value)
                "-" -> Minus(value)
                "*" -> Multiply(value)
                "/" -> Divide(value)
                else -> throw IllegalArgumentException("invalid operator : $value")
            }
        }
    }

    abstract fun operate(a: Operand, b: Operand): Operand

    data class Plus(val op: String) : Operator() {
        override fun operate(a: Operand, b: Operand): Operand {
            return a + b
        }
    }

    data class Minus(val op: String) : Operator() {
        override fun operate(a: Operand, b: Operand): Operand {
            return a - b
        }
    }

    data class Multiply(val op: String) : Operator() {
        override fun operate(a: Operand, b: Operand): Operand {
            return a * b
        }
    }

    data class Divide(val op: String) : Operator() {
        override fun operate(a: Operand, b: Operand): Operand {
            return a / b
        }
    }
}
