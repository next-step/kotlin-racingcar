package step2

enum class Operation(val symbol: String, val apply: (Int, Int) -> Int) {
    ADDITION("+", { a, b -> a + b }),
    SUBTRACTION("-", { a, b -> a - b }),
    MULTIPLICATION("*", { a, b -> a * b }),
    DIVISION("/", { a, b -> check(b != 0) { "0으로는 나눌 수 없습니다!" }; a / b })
}
