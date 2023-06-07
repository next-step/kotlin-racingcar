package calculator.domain

interface Operable {
    fun operate(x: Double, y: Double): Double
}

enum class Operator(val value: String) : Operable {
    PLUS("+") {
        override fun operate(x: Double, y: Double): Double = x + y
    },
    MINUS("-") {
        override fun operate(x: Double, y: Double): Double = x - y
    },
    TIMES("*") {
        override fun operate(x: Double, y: Double): Double = x * y
    },
    DIVIDE("/") {
        override fun operate(x: Double, y: Double): Double = x / y
    };

    companion object {
        fun findOperate(c: Char): Operator {
            return when (c) {
                '+' -> PLUS
                '-' -> MINUS
                '*' -> TIMES
                '/' -> DIVIDE
                else -> throw IllegalArgumentException("사칙 연산 기호가 아닌 문자가 존재합니다.")
            }
        }
    }
}
