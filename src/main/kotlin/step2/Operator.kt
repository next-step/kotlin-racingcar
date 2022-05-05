package step2

enum class Operator(expr: String, var evaluate: (num1: Int, num2: Int) -> Int) {
    PLUS("+", {num1: Int, num2: Int -> num1 + num2 }),
    MINUS("-", {num1: Int, num2: Int -> num1 - num2 }),
    MULTIPLY("-", {num1: Int, num2: Int -> num1 * num2 });
}
