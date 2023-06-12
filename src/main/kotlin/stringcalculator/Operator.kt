package stringcalculator

enum class Operator(
    val operation: (Int, Int)
    -> Int
) {
    PLUS({ a, b -> a + b }),
    MINUS({ a, b -> a - b }),
    TIMES({ a, b -> a * b }),
    DIVIDE({ a, b ->
        if (b == 0) {
            throw IllegalArgumentException("Division by zero is not allowed")
        }
        a / b
    });
}