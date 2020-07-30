package week1.step2

enum class Operator(val op: Char, val opCal: (first: Double, second: Double) -> Double) {
    PLUS('+', { first, second ->
        first + second
    }),
    MINUS('-', { first, second ->
        first - second
    }),
    MULTIPLE('*', { first, second ->
        first * second
    }),
    DIVIDE('/', { first, second ->
        if (first == 0.0 || second == 0.0) {
            throw throw ArithmeticException("0으로 나눌 수 없습니다.")
        }
        first / second
    });

    companion object {
        fun findByOpCode(op: Char): Operator =
            values().firstOrNull { it.op == op } ?: throw IllegalArgumentException("사칙 연산 기호가 아닙니다.")
    }
}

