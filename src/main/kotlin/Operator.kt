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
}
