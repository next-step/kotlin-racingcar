package calculator

enum class Operator(val symbol: String, val apply: (Double, Double) -> Double) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    TIMES("*", { left, right -> left * right }),
    DIVIDE("/", { left, right ->
        require(right != 0.0) { "0으로 나눌 수 없습니다." }
        left / right
    });
}