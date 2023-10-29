package calculator

import com.sun.org.apache.xpath.internal.operations.Plus

enum class Operator(val op: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun operate(x: Int, y: Int, op: Operator): Int {
            val result = when (op) {
                PLUS -> x + y
                MINUS -> x - y
                MULTIPLY -> x * y
                DIVIDE -> x / y
            }
            return result
        }

        fun checkOperator(op : String): Operator {
            val result = when (op) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다. : $op")
            }
            return result
        }

        fun operateTo(op : String): Operator? {
            return values().find{it.op == op}
        }
}

}