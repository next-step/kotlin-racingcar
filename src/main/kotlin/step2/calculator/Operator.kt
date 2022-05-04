package step2.calculator

enum class Operator(
    val symbol: String,
    val operate: (num1: Double, num2: Double) -> Double
) {
    PLUS("+", { num1, num2 ->
        num1 + num2
    }),
    MINUS("-", { num1, num2 ->
        num1 - num2
    }),
    MULTIPLY("*", { num1, num2 ->
        num1 * num2
    }),
    DIVIDE("/", { num1, num2 ->
        num1 / num2
    })
}