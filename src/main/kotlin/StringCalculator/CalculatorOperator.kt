package StringCalculator

enum class CalculatorOperator(
    val symbol: String,
    val calculate: (Int, Int) -> Int
) {
    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        if (b == 0) throw IllegalArgumentException()
        a / b
    })
}
