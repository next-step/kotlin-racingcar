package study.racingcar

enum class Operator(
    val symbol: String,
    val calcFunc: (Int, Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> if (b == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다.") else a / b }),
    CHECK("", { _, _ -> 0 });

    fun isValid(s: String): Boolean {
        return s in Operator.values().map { it.symbol }
    }
}
