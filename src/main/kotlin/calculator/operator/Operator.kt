package calculator.operator

enum class Operator(
    private val sign: String,
    private val calculation: (Int, Int) -> Int
) {
    Plus("+", { a, b -> a + b }),
    Minus("-", { a, b -> a - b }),
    Multiply("*", { a, b -> a * b }),
    Divide("/", { a, b -> a / b });

    fun calculate(a: Int, b: Int): Int {
        return calculation(a, b)
    }

    fun isEqualSign(op: String): Boolean {
        return op == sign
    }
}
